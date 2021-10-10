package co.edu.udea.pexshop.domain.pet.controller;

import co.edu.udea.pexshop.domain.commons.jwt.JWTUtils;
import co.edu.udea.pexshop.domain.pet.mapper.IPetRequestMapper;
import co.edu.udea.pexshop.domain.pet.mapper.IPetResponseMapper;
import co.edu.udea.pexshop.domain.pet.model.dto.PetRequestDTO;
import co.edu.udea.pexshop.domain.pet.model.dto.PetResponseDTO;
import co.edu.udea.pexshop.domain.pet.model.entity.Pet;
import co.edu.udea.pexshop.domain.pet.service.IPetService;
import co.edu.udea.pexshop.domain.pet.util.listmapper.IPetResponseListMapper;
import co.edu.udea.pexshop.domain.user.model.entity.User;
import co.edu.udea.pexshop.domain.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/pet")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class PetController {

    @Autowired
    private IPetService iPetService;
    @Autowired
    private IPetResponseListMapper iPetResponseListMapper;
    @Autowired
    private IPetRequestMapper iPetRequestMapper;
    @Autowired
    private IPetResponseMapper iPetResponseMapper;
    @Qualifier("userServiceImpl")
    @Autowired
    private IUserService iUserService;

    @Autowired
    private JWTUtils jwtUtils;

    @PreAuthorize("hasAuthority('list_all_pets')")
    @GetMapping
    public ResponseEntity<List<PetResponseDTO>> listAll(){
        List<Pet> pets = iPetService.findAll();
        List<PetResponseDTO> petsResponseDTO = iPetResponseListMapper.modelToDto(pets);
        return ResponseEntity.ok(petsResponseDTO);
    }

    @PreAuthorize("hasAuthority('list_pets_by_user')")
    @GetMapping(value = "/owner/{username}")
    public ResponseEntity<List<PetResponseDTO>> listByOwnerUsername(@PathVariable("username") String username){
        List<Pet> pets = iPetService.findAllByOwner(iUserService.findUserByUsername(username));
        if (pets.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        List<PetResponseDTO> petsResponseDTO = iPetResponseListMapper.modelToDto(pets);
        return ResponseEntity.ok(petsResponseDTO);
    }

    @PreAuthorize("hasAuthority('accept_pet')")
    @GetMapping(value = "/accept/{id}")
    public ResponseEntity<PetResponseDTO> acceptPet(@PathVariable("id") Long id){
        Pet pet = iPetService.acceptPet(id);
        if (pet == null){
            return ResponseEntity.notFound().build();
        }
        PetResponseDTO petResponseDTO = iPetResponseMapper.petModelToDto(pet);
        return ResponseEntity.ok(petResponseDTO);
    }

    @PreAuthorize("hasAuthority('list_pets_status')")
    @GetMapping(value = "/pending")
    public ResponseEntity<List<PetResponseDTO>> listPetsByStatusPending(){
        List<Pet> pets = iPetService.findAllPendingPets("PENDING");
        if (pets.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        List<PetResponseDTO>petResponseDTOS = iPetResponseListMapper.modelToDto(pets);
        return ResponseEntity.ok(petResponseDTOS);
    }

    @PreAuthorize("hasAuthority('create_pet')")
    @PostMapping
    public ResponseEntity<PetResponseDTO> createPet(@RequestBody PetRequestDTO petRequestDTO, @RequestHeader (name="Authorization") String token){
        String userForPet = jwtUtils.getJWTUser(token);
        User user = iUserService.findUserByUsername(userForPet);
        Pet pet = iPetService.create(iPetRequestMapper.dtoToModel(petRequestDTO, user.getId()));

        PetResponseDTO petResponseDTO = iPetResponseMapper.petModelToDto(pet);
        return ResponseEntity.status(HttpStatus.OK).body(petResponseDTO);
    }

    @PreAuthorize("hasAuthority('update_pet')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<PetResponseDTO> updatePet(@PathVariable("id") Long id, @RequestBody PetRequestDTO petRequestDTO,  @RequestHeader (name="Authorization") String token){
        petRequestDTO.setId(id);
        String userForPet = jwtUtils.getJWTUser(token);
        User user = iUserService.findUserByUsername(userForPet);
        Pet pet= iPetService.updatePet(iPetRequestMapper.dtoToModel(petRequestDTO, user.getId()));
        if (pet == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(iPetResponseMapper.petModelToDto(pet));
    }

    @PreAuthorize("hasAuthority('delete_pet')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PetResponseDTO> deleteById(@PathVariable("id") Long id,  @RequestHeader (name="Authorization") String token){

        String userForPet = jwtUtils.getJWTUser(token);
        User user = iUserService.findUserByUsername(userForPet);
        Pet pet = iPetService.getPetByUserIdAndPetId(id, user.getId());
        if (pet == null){
            return ResponseEntity.notFound().build();
        }
        PetResponseDTO petResponseDTO = iPetResponseMapper.petModelToDto(pet);
        return ResponseEntity.ok(petResponseDTO);
    }

}

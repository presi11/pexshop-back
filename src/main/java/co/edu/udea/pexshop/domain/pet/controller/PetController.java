package co.edu.udea.pexshop.domain.pet.controller;

import co.edu.udea.pexshop.domain.pet.mapper.IPetRequestMapper;
import co.edu.udea.pexshop.domain.pet.mapper.IPetResponseMapper;
import co.edu.udea.pexshop.domain.pet.model.dto.PetRequestDTO;
import co.edu.udea.pexshop.domain.pet.model.dto.PetResponseDTO;
import co.edu.udea.pexshop.domain.pet.model.entity.Pet;
import co.edu.udea.pexshop.domain.pet.service.IPetService;
import co.edu.udea.pexshop.domain.pet.util.listmapper.IPetResponseListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public ResponseEntity<List<PetResponseDTO>> listAll(){
        List<Pet> pets = iPetService.findAll();
        List<PetResponseDTO> petsResponseDTO = iPetResponseListMapper.modelToDto(pets);
        return ResponseEntity.ok(petsResponseDTO);
    }

    @PostMapping
    public ResponseEntity<PetResponseDTO> createPet(@RequestBody PetRequestDTO petRequestDTO){
        Pet pet = iPetService.create(iPetRequestMapper.dtoToModel(petRequestDTO));
        PetResponseDTO petResponseDTO = iPetResponseMapper.modelToDto(pet);
        return ResponseEntity.status(HttpStatus.OK).body(petResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PetResponseDTO> updatePet(@PathVariable("id") Long id, @RequestBody PetRequestDTO petRequestDTO ){
        petRequestDTO.setId(id);
        Pet pet= iPetService.updatePet(iPetRequestMapper.dtoToModel(petRequestDTO));
        if (pet == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(iPetResponseMapper.modelToDto(pet));
    }

}

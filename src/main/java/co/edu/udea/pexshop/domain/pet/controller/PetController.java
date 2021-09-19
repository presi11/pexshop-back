package co.edu.udea.pexshop.domain.pet.controller;

import co.edu.udea.pexshop.domain.pet.model.dto.PetRequestDTO;
import co.edu.udea.pexshop.domain.pet.model.dto.PetResponseDTO;
import co.edu.udea.pexshop.domain.pet.model.entity.Pet;
import co.edu.udea.pexshop.domain.pet.service.IPetService;
import co.edu.udea.pexshop.domain.pet.util.listmapper.IPetResponseListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/pet")
public class PetController {

    @Autowired
    private IPetService iPetService;
    @Autowired
    private IPetResponseListMapper iPetResponseListMapper;

    @GetMapping
    public ResponseEntity<List<PetResponseDTO>> listAll(){
        List<Pet> pets = iPetService.findAll();
        List<PetResponseDTO> petsResponseDTO = iPetResponseListMapper.modelToDto(pets);
        return ResponseEntity.ok(petsResponseDTO);
    }

}

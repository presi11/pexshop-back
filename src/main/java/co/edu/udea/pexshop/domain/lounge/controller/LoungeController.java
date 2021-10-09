package co.edu.udea.pexshop.domain.lounge.controller;

import co.edu.udea.pexshop.domain.lounge.model.entity.LoungeEntity;
import co.edu.udea.pexshop.domain.lounge.service.ILoungeService;
import co.edu.udea.pexshop.domain.lounge.service.LoungeServiceImplemented;
import co.edu.udea.pexshop.domain.pet.model.dto.PetResponseDTO;
import co.edu.udea.pexshop.domain.pet.model.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/lounge")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class LoungeController {

    @Autowired
    private LoungeServiceImplemented loungeService;

    @GetMapping
    public ResponseEntity<List<?>> listAll(){
        List<LoungeEntity> lounges = loungeService.findAll();
        return ResponseEntity.ok(lounges);
    }
}

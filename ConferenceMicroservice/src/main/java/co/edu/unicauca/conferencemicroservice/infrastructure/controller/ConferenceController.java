package co.edu.unicauca.conferencemicroservice.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import co.edu.unicauca.conferencemicroservice.application.dto.ConferenceDTO;
import co.edu.unicauca.conferencemicroservice.application.dto.ListConferencesDTO;
import co.edu.unicauca.conferencemicroservice.application.dto.ListConferencesOrganizerDTO;
import co.edu.unicauca.conferencemicroservice.application.mapper.MapperConference;
import co.edu.unicauca.conferencemicroservice.application.port.in.IConferenceService;
import co.edu.unicauca.conferencemicroservice.domain.model.Conference;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/conferences")
public class ConferenceController {

    private final IConferenceService conferenceService;

    @Autowired
    public ConferenceController(IConferenceService conferenceService){
        this.conferenceService = conferenceService;
    }

    @PostMapping
    public ResponseEntity<ConferenceDTO> createConference(
            @RequestBody ConferenceDTO conferenceDTO
    ){
        // Assuming that the idOrganizer of  conferenceDTO is valid
        // and is an organizer.
        ConferenceDTO conferenceCreated = MapperConference.toConferenceDTO(
                conferenceService.save(conferenceDTO)
        );
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body( conferenceCreated );
    }

    @GetMapping

    public ResponseEntity<ListConferencesDTO> getConferences(){
        List<Conference> conferences = conferenceService.findAllConferencesActive();
        ListConferencesDTO response = new ListConferencesDTO();
        response.setConferences( new ArrayList<>() );

        for(Conference conferenceItem: conferences)
            response.getConferences().add(MapperConference.toConferenceDTO(conferenceItem));

        response.setTotalConferences( conferences.size() );

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/organizer/{idOrganizer}")

    public ResponseEntity<ListConferencesOrganizerDTO> getConferenceOrganizer(@PathVariable String idOrganizer){
        // Assuming the idOrganizer is valid and exist the organizer
        ListConferencesOrganizerDTO response = new ListConferencesOrganizerDTO();
        response.setConferences( new ArrayList<>() );
        response.setIdOrganizer( idOrganizer );

        List<Conference> conferences = conferenceService.findAllConfereceByIDOrganizer( idOrganizer );
        for (Conference conference: conferences)
            response.getConferences().add(
                    MapperConference.toConferenceDTO(conference)
            );
        response.setTotalConference( conferences.size() );

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PutMapping("/{idConference}")
    public ResponseEntity<ConferenceDTO> updateConference(
            @PathVariable String idConference,
            @RequestBody ConferenceDTO conferenceDTO
    ){
        //Assuming the own have permission and is active
        Conference conferenceUpdated =
                conferenceService.updateConference(idConference, conferenceDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body( MapperConference.toConferenceDTO( conferenceUpdated ));
    }

    @DeleteMapping("/{idConference}")
    public ResponseEntity<ConferenceDTO> deleteConference(@PathVariable String idConference){
        Conference conferenceDeleted =
                conferenceService.deleteConference(idConference);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body( MapperConference.toConferenceDTO( conferenceDeleted) );
    }
}

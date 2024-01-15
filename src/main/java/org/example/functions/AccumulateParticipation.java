package org.example.functions;

import org.example.APIServer;
import org.example.dtos.SendDTO;
import org.mongodb.morphia.query.Query;

public class AccumulateParticipation extends APIServer {



    public static SendDTO verifyParticipation(SendDTO sendDTO) {
        String firstName = sendDTO.getFirstName();
        String lastName = sendDTO.getLastName();
        Query<SendDTO> query = datastore.createQuery(SendDTO.class)
                .field("firstName").equal(firstName)
                .field("lastName").equal(lastName);
        SendDTO lastRegister = datastore.createQuery(SendDTO.class)
                                            .field("firstName").equal(firstName)
                                            .field("lastName").equal(lastName).get();
        if (lastRegister != null) {
            sendDTO.setParticipation(sendDTO.getParticipation() + lastRegister.getParticipation());
            datastore.delete(query);

        }
        return sendDTO;
    }
}

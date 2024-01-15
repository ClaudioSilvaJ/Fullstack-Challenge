package com.desFS.services;

import com.desFS.util.APIBaseTest;
import org.example.dtos.SendDTO;
import org.junit.Test;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
@SuppressWarnings({"unchecked", "unused"})
public class MainServicesTest extends APIBaseTest {

    @Test
    public void registerSendTest(){
        SendDTO sendDTO_1 = createSend("Dummy", "1", 10);
        SendDTO sendDTO_2 = createSend("Dummy", "2", 10);
        assertEqualsCreated(mainServices.register(sendDTO_1));
        assertEqualsCreated(mainServices.register(sendDTO_2));
        Response response = mainServices.get();
        List<SendDTO> sendDTOList = (List<SendDTO>) response.getEntity();
        assertEqualsOK(response);
        assertEquals(2, sendDTOList.size());
    }

    @Test
    public void accumulateParticipationTest(){
        SendDTO sendDTO_1 = createSend("Dummy", "1", 10);
        SendDTO sendDTO_2 = createSend("Dummy", "1", 10);
        Response response = mainServices.get();
        List<SendDTO> sendDTOList = (List<SendDTO>) response.getEntity();
        assertEqualsOK(response);
        assertEquals(1, sendDTOList.size());
        assertEquals(20, sendDTOList.get(0).getParticipation());
    }

    public SendDTO createSend(String firstName, String lastName, int participation) {
        Random random = new Random();
        SendDTO sendDTO = new SendDTO();
        sendDTO.setFirstName(firstName);
        sendDTO.setLastName(lastName);
        sendDTO.setParticipation(participation);
        assertEqualsCreated(mainServices.register(sendDTO));
        return sendDTO;
    }
}

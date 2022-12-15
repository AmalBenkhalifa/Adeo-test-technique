package adeo.leroymerlin.cdp;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

    @ExtendWith(MockitoExtension.class)
    class EventControllerIntegrationTest {

        @Mock
        EventRepository eventRepository;

        EventService eventService;

        @BeforeEach
        public void setUp() {
            eventService = new EventService(eventRepository);

//        setField(eventService, "eventRepository", eventRepository);
        }

        @Test
        void shouldReturnFilteredEvents() {

            when(eventRepository.findAllBy()).thenReturn(mockListEvent());
            List<Event> filteredEvents = eventService.getFilteredEvents("Wa");

            Assertions.assertThat(filteredEvents).isEqualTo(new ArrayList<>());

        }

        private List<Event> mockListEvent() {
            return new ArrayList<>();
        }
    }
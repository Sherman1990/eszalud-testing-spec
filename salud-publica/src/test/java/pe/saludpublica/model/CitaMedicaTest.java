package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    private static final LocalDateTime FECHA = LocalDateTime.of(2026, 12, 1, 9, 30);

    @Test
    @DisplayName("Crear una cita médica con datos válidos")
    void shouldCreateAppointmentWithValidData() {
        CitaMedica cita = new CitaMedica(
                "PAC-1", "DOC-1", "ESP-1", FECHA, "Dolor de cabeza",
                EstadoCita.PROGRAMADA);

        assertNotNull(cita);
        assertEquals("PAC-1", cita.getPaciente());
        assertEquals("DOC-1", cita.getDoctor());
        assertEquals("ESP-1", cita.getEspecialidad());
        assertEquals(FECHA, cita.getFechaHora());
        assertEquals("Dolor de cabeza", cita.getMotivo());
        assertEquals(EstadoCita.PROGRAMADA, cita.getEstado());
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin paciente")
    void shouldRejectAppointmentWithoutPatient() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica(null, "DOC-1", "ESP-1", FECHA,
                        "Control", EstadoCita.PROGRAMADA));
    }

    @Test
    @DisplayName("Rechazar la creación de una cita sin doctor")
    void shouldRejectAppointmentWithoutDoctor() {
        assertThrows(IllegalArgumentException.class,
                () -> new CitaMedica("PAC-1", null, "ESP-1", FECHA,
                        "Control", EstadoCita.PROGRAMADA));
    }
}
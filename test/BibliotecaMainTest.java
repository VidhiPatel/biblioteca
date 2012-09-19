import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BibliotecaMainTest {
    @Test(timeout = 500)
    public void shouldExitMenuOperationsOnChoosingExit() throws Exception {
        Biblioteca mockBiblioteca = mock(Biblioteca.class);
        when(mockBiblioteca.performMenuSelection()).thenReturn(false);

        new BibliotecaMain(mockBiblioteca).run();
    }
}

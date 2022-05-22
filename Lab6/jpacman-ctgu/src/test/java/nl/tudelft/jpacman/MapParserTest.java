package nl.tudelft.jpacman;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import java.io.IOException;

import static org.mockito.Mockito.verify;

public class MapParserTest {

    @Mock
    private BoardFactory boardFactory = mock(BoardFactory.class);

    @Mock
    private LevelFactory levelFactory = mock(LevelFactory.class);

    private MapParser mapParser = new MapParser(levelFactory, boardFactory);


    @Test
    void testMapParser() throws IOException {
        mapParser.parseMap("/mymap1.txt");
        verify(boardFactory, times(46)).createWall();
        verify(boardFactory, times(28)).createGround();
    }

    @Test
    void testMapParser2() throws IOException {
        assertThatThrownBy(()->{
            mapParser.parseMap("/unrecognizedcharmap.txt");
        }).isInstanceOf(PacmanConfigurationException.class).hasMessage(
            "Invalid character at 0,0: A"
        );
    }

    @Test
    void testMapParser3() throws IOException {
        assertThatThrownBy(()->{
            mapParser.parseMap("/404.txt");
        }).isInstanceOf(PacmanConfigurationException.class).hasMessage(
            "Could not get resource for: /404.txt"
        );
    }
}

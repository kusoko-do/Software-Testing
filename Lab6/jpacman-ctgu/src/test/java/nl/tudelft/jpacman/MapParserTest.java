package nl.tudelft.jpacman;

import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nl.tudelft.jpacman.level.Pellet;
import nl.tudelft.jpacman.npc.Ghost;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.verify;

public class MapParserTest {

    @Mock
    private static BoardFactory boardFactory = mock(BoardFactory.class);

    @Mock
    private static LevelFactory levelFactory = mock(LevelFactory.class);

    private final MapParser mapParser = new MapParser(levelFactory, boardFactory);

    @BeforeAll
    private static void init(){
        when(boardFactory.createBoard((any()))).thenReturn(mock(Board.class));
        when(levelFactory.createLevel(any(),any(),any())).thenReturn(mock(Level.class));
        when(levelFactory.createPellet()).thenReturn(mock(Pellet.class));
        when(levelFactory.createGhost()).thenReturn(mock(Ghost.class));
    }


    @Test
    @DisplayName("正常运行时函数调用测试")
    void testMapParser() throws IOException {
        mapParser.parseMap("/mymap1.txt");

        //验证createBoard函数调用是否符合预期
        verify(boardFactory, times(1)).createBoard(any());
        //验证createWall函数调用是否符合预期
        verify(boardFactory, times(45)).createWall();
        //验证createGround函数调用是否符合预期
        verify(boardFactory, times(29)).createGround();

        //验证createLevel函数调用是否符合预期
        verify(levelFactory, times(1)).createLevel(any(),any(),any());
        //验证createGhost函数调用是否符合预期
        verify(levelFactory, times(2)).createGhost();
        //验证createPellet函数调用是否符合预期
        verify(levelFactory, times(1)).createPellet();
    }

    @Test
    @DisplayName("地图内容有误")
    void testMapParser2() throws IOException {
        assertThatThrownBy(()->{
            mapParser.parseMap("/unrecognizedcharmap.txt");
        }).isInstanceOf(PacmanConfigurationException.class).hasMessage(
            "Invalid character at 0,0: A"
        );
    }

    @Test
    @DisplayName("文件为空")
    void testMapParser3(){
        assertThatThrownBy(()->{
            mapParser.parseMap("/emptymap.txt");
        }).isInstanceOf(PacmanConfigurationException.class).hasMessage("Input text must consist of at least 1 row.");
    }

    @Test
    @DisplayName("List<String>对象为空")
    void testMapParser4(){
        List<String> text = null;
        assertThatThrownBy(()->{
            mapParser.parseMap(text);
        }).isInstanceOf(PacmanConfigurationException.class).hasMessage("Input text cannot be null.");
    }

    @Test
    @DisplayName("格式有误（第一行为空）")
    void testMapParser5(){
        assertThatThrownBy(()->{
            mapParser.parseMap("/errormap1.txt");
        }).isInstanceOf(PacmanConfigurationException.class).hasMessage("Input text lines cannot be empty.");
    }
    @Test
    @DisplayName("格式有误（行长度不一致）")
    void testMapParser6(){
        assertThatThrownBy(()->{
            mapParser.parseMap("/errormap2.txt");
        }).isInstanceOf(PacmanConfigurationException.class).hasMessage("Input text lines are not of equal width.");
    }


    @Test
    @DisplayName("路径有误")
    void testMapParser7() throws IOException {
        assertThatThrownBy(()->{
            mapParser.parseMap("/404.txt");
        }).isInstanceOf(PacmanConfigurationException.class).hasMessage(
            "Could not get resource for: /404.txt"
        );
    }

}

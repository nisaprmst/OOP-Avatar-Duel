package com.avatarduel.gamemanager;

import com.avatarduel.cards.Element;
import com.avatarduel.cards.LandCard;
import com.avatarduel.exceptions.InvalidFieldIndexException;
import com.avatarduel.exceptions.NoCardInFieldException;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

public class PlayerTest {
    private Player player;

    @Before
    public void setUp() {
        player = new Player();
        player.setNama("Panji");
        LandCard land = new LandCard(1, "entah", "coba", Element.AIR, "cobs");
        player.addPower(land);
        HashMap<Element, Integer> power = new HashMap<>();
        for (Element el: Element.values()) {
            power.put(el, 2);
        }
        player.setPower(power);

    }

    @Test
    public void getAttackAtPos() {
        AtomicInteger att = new AtomicInteger();
        boolean thrown = false;
        try {
            att.set(player.getAttackAtPos(3));
        } catch (NoCardInFieldException e) {
            thrown = true;
        } catch (InvalidFieldIndexException ignored) {

        }
        assertTrue(thrown);
    }

    @Test
    public void getDefenseAtPos() {
        AtomicInteger def = new AtomicInteger();
        boolean thrown = false;
        try {
            def.set(player.getDefenseAtPos(8));
        } catch (InvalidFieldIndexException e) {
            thrown = true;
        } catch (NoCardInFieldException ignored) {

        }
        assertTrue(thrown);
    }

    @Test
    public void substractHp() {
        player.substractHp(10);
        assertEquals(90, player.getHp());
    }

    @Test
    public void draw() {
        player.draw();
        assertEquals(8, player.getCardsInHand().size());
    }

    @Test
    public void resetPower() {
        player.resetPower();
        for (Element el: Element.values()) {
            assertEquals((Object)2, (Object)player.getCurrPower().get(el));
        }
    }

    @Test
    public void isPowerEnough() {
    }

    @Test
    public void testIsPowerEnough() {
    }

    @Test
    public void usePower() {
    }

    @Test
    public void testUsePower() {
    }

    @Test
    public void removeFromHand() {
    }

    @Test
    public void removeCharacter() {
    }

    @Test
    public void removeSkill() {
    }

    @Test
    public void canAttack() {
    }

    @Test
    public void canChangePos() {
    }

    @Test
    public void isCharacterFieldEmpty() {
    }
}
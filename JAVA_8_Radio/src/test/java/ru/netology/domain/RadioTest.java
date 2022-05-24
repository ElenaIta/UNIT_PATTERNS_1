package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {
    @Test  //  1/1
    public void setCurrentStation1() {
        Radio rd = new Radio();
        rd.setCurrentStation(9);
        int expected = 9;
        int actual = rd.getCurrentStation();

        assertEquals(expected, actual);

    }

    @Test  // 1/2
    public void setCurrentStation2() {
        Radio rd = new Radio();
        rd.setCurrentStation(-1);
        int expected = 0;
        int actual = rd.getCurrentStation();

        assertEquals(expected, actual);

    }

    @Test  // 1/3
    public void setCurrentStation3() {
        Radio rd = new Radio();
        rd.setCurrentStation(10);
        int expected = 0;
        int actual = rd.getCurrentStation();
        assertEquals(expected, actual);

    }

    @Test // 2/1
    public void setNextStation1() {
        Radio rd = new Radio();
        rd.setCurrentStation(9);

        rd.setNextStation();

        int expected = 0;
        int actual = rd.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test // 2/2
    public void setNextStation2() {
        Radio rd = new Radio();
        rd.setCurrentStation(0);

        rd.setNextStation();
        int expected = 1;
        int actual = rd.getCurrentStation();
        assertEquals(expected, actual);
    }


    @Test // 3/1
    public void setPrevStation1() {
        Radio rd = new Radio();
        rd.setCurrentStation(0);

        rd.setPrevStation();
        int expected = 9;
        int actual = rd.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test // 3/2
    public void setPrevStation2() {
        Radio rd = new Radio();
        rd.setCurrentStation(9);

        rd.setPrevStation();
        int expected = 8;
        int actual = rd.getCurrentStation();
        assertEquals(expected, actual);
    }

//    @Test  //  4/1
//    public void setCurrentVolume1() {
//        Radio rd = new Radio();
//        rd.setCurrentVolume(10);
//        int expected = 10;
//        int actual = rd.getCurrentVolume();
//        assertEquals(expected, actual);
//    }

    @Test  // 4/2
    public void setCurrentVolume2() {
        Radio rd = new Radio();
        rd.setCurrentVolume(-1);
        int expected = 0;
        int actual = rd.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test  // 4/3
    public void setCurrentVolume3() {
        Radio rd = new Radio();
        rd.setCurrentVolume(11);
        int expected = 0;
        int actual = rd.getCurrentVolume();
        assertEquals(expected, actual);
    }

//    @Test  // 5
//    public void setPlusVolume1() {
//        Radio rd = new Radio();
//        rd.setCurrentVolume(6);
//
//        int expected = 7;
//        int actual = rd.getCurrentVolume();
//        assertEquals(expected, actual);
//    }

    @Test // 6
    public void setMinusVolume1() {
        Radio rd = new Radio();
        rd.setCurrentVolume(1);

        rd.setMinusVolume();
        int expected = 0;
        int actual = rd.getCurrentVolume();
        assertEquals(expected, actual);
    }

}

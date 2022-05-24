package ru.netology.domain;

public class Radio {
    public int getCurrentStation() {
        return currentStation;
    }

    private int currentStation;
    private int maxStation = 9;
    private int minStation = 0;


    // 1 выставлять номер радиостанции через прямое указание её номера
    public void setCurrentStation(int newCurrentStation) {

        if (newCurrentStation > 9) {
            return;
        }
        if (newCurrentStation < 0) {
            return;
        }
        currentStation = newCurrentStation;
    }

    // 2 переключение последней станции на первую
    public void setNextStation() {
        if (currentStation == maxStation) {
            setCurrentStation(minStation);
        } else {
            setCurrentStation(currentStation + 1);
        }
    }

    // 3 переключение первой станции на последнюю
    public void setPrevStation() {
        if (currentStation == minStation) {
            setCurrentStation(currentStation = maxStation);
        } else {
            setCurrentStation(currentStation - 1);
        }
    }


    public int getCurrentVolume() {
        return currentVolume;
    }

    private int currentVolume;
    private int maxVolume = 10;
    private int minVolume = 0;


    // 4 диапазон звука
    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume > 10) {
            return;
        }
        if (newCurrentVolume < 0) {
            return;
        }
        setCurrentVolume(newCurrentVolume);
    }


    // 5 увеличение звука
    public void setPlusVolume() {
        if (currentVolume < 10) {
            currentVolume = currentVolume + 1;
        }
    }

    // 6 уменьшение звука
    public void setMinusVolume() {
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        }
    }


}









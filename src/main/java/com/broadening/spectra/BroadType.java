package com.broadening.spectra;

public enum BroadType {
    GAUSSIAN(1),
    LORENZ(2);

    int code;

    BroadType(int code){
        this.code = code;
    }


}

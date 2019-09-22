package com.broadening.spectra;

import java.util.List;

public interface Broadening {

    List<Double> broadening();

    void setBroadeningType(BroadType type);

    void setSpectralRange(int start, int finish);

    void setUnits(UnitsType type);

    void setScaleFactor(Double factor);

    void setBroadeningFactor(Double factor);

    void setTypeOfSpectrum(SpectrumType type);

}

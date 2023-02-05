package com.lapin.web4.DTO;

import com.lapin.web4.utility.Checker;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointDTO {
    private Long id;
    private String username;
    @NotNull
    private String x;
    @NotNull
    private String y;
    @NotNull
    private String r;

    private String time;

    private String executionTime;

    private String hitResult;

    public String isHitResult() {
        return hitResult;
    }

    public void setHitResult(String x, String y, String r) {
        Double xVal = Double.parseDouble(x.replace(",", "."));
        Double yVal = Double.parseDouble(y.replace(",", "."));
        Double rVal = Double.parseDouble(r.replace(",", "."));
        this.hitResult = new Checker(xVal, yVal, rVal).checkHit() ? "true" : "false";
    }

}

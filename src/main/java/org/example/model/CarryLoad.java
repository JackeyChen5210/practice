package org.example.model;

import lombok.Data;

/**
 * @author jack
 */
@Data
public class CarryLoad {
    private Integer luggageCount;
    private Integer mailCount;
    private Integer cargoCount;

    public Integer sum() {
        return luggageCount + mailCount + cargoCount;
    }
}

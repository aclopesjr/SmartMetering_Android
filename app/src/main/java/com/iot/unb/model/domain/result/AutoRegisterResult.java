package com.iot.unb.model.domain.result;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aclopesjr on 5/9/17.
 */

public class AutoRegisterResult {

    @SerializedName("tokenId")
    private String tokenId;

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }
}

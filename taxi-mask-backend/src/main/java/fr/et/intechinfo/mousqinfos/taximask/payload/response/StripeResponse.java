package fr.et.intechinfo.mousqinfos.taximask.payload.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StripeResponse {
    private String id, status, chargeId,balanceTransaction;

}

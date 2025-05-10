package com.aem.icici.core.models.fixedDepositCard;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class},
       adapters = FixedDepositCard.class,
       resourceType = "icici/components/fixed_deposit_card",
       defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FixedDepositCardImpl implements FixedDepositCard {
    
    @ValueMapValue
    private String badgeLabel;
    
    @ValueMapValue
    private String interestRateTitle;
    
    @ValueMapValue
    private Double interestRateValue;
    
    @ValueMapValue
    private Double effectiveYieldValue;
    
    @ValueMapValue
    private String maturityAmount;
    
    @ValueMapValue
    private String totalInterest;
    
    @ValueMapValue
    private String duration;
    
    @ValueMapValue
    private Date maturityDate;
    
    @ValueMapValue
    private String primaryButtonText;
    
    @ValueMapValue
    private String primaryButtonLink;
    
    @ValueMapValue
    private String secondaryButtonText;
    
    @ValueMapValue
    private String secondaryButtonLink;
    
    @ValueMapValue
    private String tdsNote;
    
    private String formattedMaturityDate;
    
    @PostConstruct
    protected void init() {
        if (maturityDate != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
            formattedMaturityDate = dateFormat.format(maturityDate);
        }
    }
    
    @Override
    public String getBadgeLabel() {
        return badgeLabel;
    }
    
    @Override
    public String getInterestRateTitle() {
        return interestRateTitle;
    }
    
    @Override
    public String getInterestRateValue() {
        return interestRateValue != null ? String.format("%.2f%%", interestRateValue) : "";
    }
    
    @Override
    public String getEffectiveYieldValue() {
        return effectiveYieldValue != null ? String.format("%.2f%%", effectiveYieldValue) : "";
    }
    
    @Override
    public String getMaturityAmount() {
        return maturityAmount;
    }
    
    @Override
    public String getTotalInterest() {
        return totalInterest;
    }
    
    @Override
    public String getDuration() {
        return duration;
    }
    
    @Override
    public String getMaturityDate() {
        return formattedMaturityDate;
    }
    
    @Override
    public String getPrimaryButtonText() {
        return primaryButtonText;
    }
    
    @Override
    public String getPrimaryButtonLink() {
        return primaryButtonLink;
    }
    
    @Override
    public String getSecondaryButtonText() {
        return secondaryButtonText;
    }
    
    @Override
    public String getSecondaryButtonLink() {
        return secondaryButtonLink;
    }
    
    @Override
    public String getTdsNote() {
        return tdsNote;
    }

}
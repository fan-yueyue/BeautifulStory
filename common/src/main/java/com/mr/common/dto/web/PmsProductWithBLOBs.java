package com.mr.common.dto.web;

import java.io.Serializable;
import java.util.List;

public class PmsProductWithBLOBs extends PmsProduct  implements Serializable {
    private String description;

    private String detailDesc;

    private String detailHtml;

    private String detailMobileHtml;

    private List<PmsBrand> list;

    public List<PmsBrand> getList() {
        return list;
    }

    public void setList(List<PmsBrand> list) {
        this.list = list;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc == null ? null : detailDesc.trim();
    }

    public String getDetailHtml() {
        return detailHtml;
    }

    public void setDetailHtml(String detailHtml) {
        this.detailHtml = detailHtml == null ? null : detailHtml.trim();
    }

    public String getDetailMobileHtml() {
        return detailMobileHtml;
    }

    public void setDetailMobileHtml(String detailMobileHtml) {
        this.detailMobileHtml = detailMobileHtml == null ? null : detailMobileHtml.trim();
    }
}
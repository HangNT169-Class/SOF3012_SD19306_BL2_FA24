package com.poly.hangnt169.sof3012.B11_Ajax.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SinhVien {

    private String maSV;
    private String hoTen;
    private int tuoi;
    private String nganhHoc;

}

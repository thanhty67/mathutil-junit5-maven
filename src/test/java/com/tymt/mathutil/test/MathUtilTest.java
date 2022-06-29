/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.tymt.mathutil.test;

import static com.tymt.mathutil.core.MathUtil.getFactorial;
//goi ham ma ko can Class, chi ap dung cho ham Static
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
//import org.junit.jupiter.api.function.Executable;

/**
 *
 * @author ThanhTy
 */
public class MathUtilTest {

    //chơi DDT, tách data ra khỏi câu lệnh kiểm thử, tham số hóa data này
    //vào trong câu lệnh kiểm thử 
    //chuẩn bị bộ data
    public static Object[][] initData() {
        return new Integer[][]{
                                {1, 1},
                                {2, 2},
                                {5, 120},
                                {6, 720}
        };
    }
    
    @ParameterizedTest
    @MethodSource(value = "initData") //ttên hàm cung cấp data, ngầm định thứ tự
                                       //của các phần tử của mảng 
                                       //và map vào tham số hàm
    public void testGetFactorialGivenRightArgReturnWell(int input, long expected) {
        assertEquals(expected, getFactorial(input));
    }

//    @Test
//    public void testGetFactorialGivenRightArgReturnWell() {
//        assertEquals(24, getFactorial(4));
//    }

    @Test
    public void testGetFactorialGivenWrongArgThrowException() {
        //xai biểu thức Lamba
        //hàm nhận tham số thứ 2 là 1 cái object/có code implêmnt cái
        //funcitonal interface tên là Executeable - có 1 hàm duy nhất ko code

//        Executable exObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFactorial(-5);
//            }
//        };
        //Executable exObject = () -> getFactorial(-5);
        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
    }

}

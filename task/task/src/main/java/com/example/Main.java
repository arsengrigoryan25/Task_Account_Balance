package com.example;

import com.example.DTO.Balance;
import com.example.DTO.Transactions;
import com.example.Util.WorkWithDB;
import com.example.enums.BalanceType;
import com.example.enums.Currency;

import static com.example.enums.Currency.*;

public class Main {
/*
United States Dollar        (USD) $
Euro                        (EUR) €
British Pound Sterling      (GBP) £
Japanese Yen                (JPY) ¥
Australian Dollar           (AUD) $
Canadian Dollar             (CAD) $
Swiss Franc                 (CHF) CHF
Chinese Yuan                (CNY) ¥
Indian Rupee                (INR) ₹
Russian Ruble               (RUB) ₽
Brazilian Real              (BRL) R$
South African Rand          (ZAR) R
Mexican Peso                (MXN) $
Singapore Dollar            (SGD) $
New Zealand Dollar          (NZD) $
Hong Kong Dollar            (HKD) HK$
 */

    public static void main(String[] args) {

//        InitializationCurrencyFactor.setFactorUsdToEurRatio(0.88);           // 1 $  = €
//        InitializationCurrencyFactor.setFactorUsdToRubRatio(78.50);          // 1 $  = ₽
//        InitializationCurrencyFactor.setFactorUsdToBynRatio(3.27);           // 1 $  = Br

//        System.out.println(CurrencyConversion.convertEurToUsd(1));  // 1 € - $
//        System.out.println(CurrencyConversion.convertEurToRub(1));  // 1 € - ₽
//        System.out.println(CurrencyConversion.convertEurToByn(1));  // 1 € - Br
//
//        System.out.println(CurrencyConversion.convertRubToUsd(1));  // 1 ₽ - $
//        System.out.println(CurrencyConversion.convertRubToEur(1));  // 1 ₽ - €
//        System.out.println(CurrencyConversion.convertRubToByn(1));  // 1 ₽ - Br
//
//        System.out.println(CurrencyConversion.convertBynToUsd(1));  // 1 Br - $
//        System.out.println(CurrencyConversion.convertBynToEur(1));  // 1 Br - €
//        System.out.println(CurrencyConversion.convertBynToRub(1));  // 1 Br - Br

        WorkWithDB.createStatement();
        WorkWithDB.createTransactionsTable();
        WorkWithDB.createBalanceTable();

//        Transactions transactions = new Transactions("arsen", 100.0, BalanceType.CREDITED, Currency.USD);
//        WorkWithDB.addTransactions(transactions);
//
//        Balance balance = new Balance("arsen");
//        WorkWithDB.addBalance(balance);

    }
}
/*
    Country and                 Currency Code   Font:        Font:               Unicode:        Unicode:
    Currency                                    Code2000     Arial Unicode MS    Decimal         Hex
    --------------------------------------------------------------------------------------------------
    Albania Lek                 ALL             Lek         Lek                 76, 101, 107    4c, 65, 6b
    Afghanistan Afghani         AFN                                             1547            60b
؋   ؋
    Argentina Peso              ARS             $           $                   36              24
    Aruba Guilder               AWG             ƒ           ƒ                   402             192
    Australia Dollar            AUD             $           $                   36              24
    Azerbaijan Manat            AZN             ₼           ₼                   8380           20bc
    Bahamas Dollar              BSD             $           $                   36              24
    Barbados Dollar             BBD             $           $                   36              24
    Belarus Ruble               BYN             Br          Br                  66, 114         42, 72
    Belize Dollar               BZD             BZ$         BZ$                 66, 90, 36      42, 5a, 24
    Bermuda Dollar              BMD             $           $                   36              24
    Bolivia Bolíviano           BOB             $b          $b                  36, 98          24, 62
    Bosnia and Herzegovina      BAM             KM          KM                  75, 77          4b, 4d
    Convertible Mark
    Botswana Pula               BWP             P           P                   80              50
    Bulgaria Lev                BGN             лв          лв                  1083, 1074      43b, 432
    Brazil Real                 BRL             R$          R$                  82, 36          52, 24
    Brunei Darussalam Dollar    BND             $           $                   36              24
    Cambodia Riel               KHR             ៛           ៛                   6107            17db
    Canada Dollar               CAD             $           $                   36              24
    Cayman Islands Dollar       KYD             $           $                   36              24
    Chile Peso                  CLP             $           $                   36              24
    China Yuan Renminbi         CNY             ¥           ¥                   165             a5
    Colombia Peso               COP             $           $                   36              24
    Costa Rica Colon            CRC             ₡           ₡                   8353            20a1
    Croatia Kuna                HRK             kn          kn                  107, 110        6b, 6e
    Cuba Peso                   CUP             ₱           ₱                   8369            20b1
    Czech Republic Koruna       CZK             Kč          Kč                  75, 269         4b, 10d
    Denmark Krone               DKK             kr          kr                  107, 114        6b, 72
    Dominican Republic Peso     DOP             RD$         RD$                 82, 68, 36      52, 44, 24
    East Caribbean Dollar       XCD             $           $                   36              24
    Egypt Pound                 EGP             £           £                   163             a3
    El Salvador Colon           SVC             $           $                   36              24
    Euro Member Countries       EUR             €           €                   8364            20ac
    Falkland Islands            FKP             £           £                   163             a3
    (Malvinas) Pound
    Fiji Dollar                 FJD             $           $                   36              24
    Ghana Cedi                  GHS             ¢           ¢                   162             a2
    Gibraltar Pound             GIP             £           £                   163             a3
    Guatemala Quetzal           GTQ             Q           Q                   81              51
    Guernsey Pound              GGP             £           £                   163             a3
    Guyana Dollar               GYD             $           $                   36              24
    Honduras Lempira            HNL             L           L                   76              4c
    Hong Kong Dollar            HKD             $           $                   36              24
    Hungary Forint              HUF             Ft          Ft                  70, 116         46, 74
    Iceland Krona               ISK             kr          kr                  107, 114        6b, 72
    India Rupee
    INR                                                                         8377            20b9
    Indonesia Rupiah            IDR             Rp          Rp                  82, 112         52, 70
    Iran Rial                   IRR                                             65020           fdfc
    ﷼   ﷼
    Isle of Man Pound           IMP             £           £                   163             a3
    Israel Shekel               ILS             ₪           ₪                   8362            20aa
    Jamaica Dollar
    JMD
    J$
    J$
    74, 36
    4a, 24

    Japan Yen
    JPY
    ¥
    ¥
    165
    a5
    info

    Jersey Pound
    JEP
    £
    £
    163
    a3

    Kazakhstan Tenge
    KZT
    лв
    лв
    1083, 1074
    43b, 432

    Korea (North) Won
    KPW
    ₩
    ₩
    8361
    20a9

    Korea (South) Won
    KRW
    ₩
    ₩
    8361
    20a9

    Kyrgyzstan Som
    KGS
    лв
    лв
    1083, 1074
    43b, 432

    Laos Kip
    LAK
    ₭
    ₭
    8365
    20ad

    Lebanon Pound
    LBP
    £
    £
    163
    a3

    Liberia Dollar
    LRD
    $
    $
    36
    24

    Macedonia Denar
    MKD
    ден
    ден
    1076, 1077, 1085
    434, 435, 43d

    Malaysia Ringgit
    MYR
    RM
    RM
    82, 77
    52, 4d

    Mauritius Rupee
    MUR
    ₨
    ₨
    8360
    20a8

    Mexico Peso
    MXN
    $
    $
    36
    24
    info

    Mongolia Tughrik
    MNT
    ₮
    ₮
    8366
    20ae

    Mozambique Metical
    MZN
    MT
    MT
    77, 84
    4d, 54

    Namibia Dollar
    NAD
    $
    $
    36
    24

    Nepal Rupee
    NPR
    ₨
    ₨
    8360
    20a8

    Netherlands Antilles Guilder
    ANG
    ƒ
    ƒ
    402
    192

    New Zealand Dollar
    NZD
    $
    $
    36
    24

    Nicaragua Cordoba
    NIO
    C$
    C$
    67, 36
    43, 24

    Nigeria Naira
    NGN
    ₦
    ₦
    8358
    20a6

    Norway Krone
    NOK
    kr
    kr
    107, 114
    6b, 72

    Oman Rial
    OMR
    ﷼
    ﷼
    65020
    fdfc

    Pakistan Rupee
    PKR
    ₨
    ₨
    8360
    20a8

    Panama Balboa
    PAB
    B/.
    B/.
    66, 47, 46
    42, 2f, 2e

    Paraguay Guarani
    PYG
    Gs
    Gs
    71, 115
    47, 73

    Peru Sol
    PEN
    S/.
    S/.
    83, 47, 46
    53, 2f, 2e

    Philippines Peso
    PHP
    ₱
    ₱
    8369
    20b1

    Poland Zloty
    PLN
    zł
    zł
    122, 322
    7a, 142

    Qatar Riyal
    QAR
    ﷼
    ﷼
    65020
    fdfc

    Romania Leu
    RON
    lei
    lei
    108, 101, 105
    6c, 65, 69

    Russia Ruble
    RUB
    ₽
    ₽
    8381
    20bd

    Saint Helena Pound
    SHP
    £
    £
    163
    a3

    Saudi Arabia Riyal
    SAR
    ﷼
    ﷼
    65020
    fdfc

    Serbia Dinar
    RSD
    Дин.
    Дин.
    1044, 1080, 1085, 46
    414, 438, 43d, 2e

    Seychelles Rupee
    SCR
    ₨
    ₨
    8360
    20a8

    Singapore Dollar
    SGD
    $
    $
    36
    24

    Solomon Islands Dollar
    SBD
    $
    $
    36
    24

    Somalia Shilling
    SOS
    S
    S
    83
    53

    South Africa Rand
    ZAR
    R
    R
    82
    52

    Sri Lanka Rupee
    LKR
    ₨
    ₨
    8360
    20a8

    Sweden Krona
    SEK
    kr
    kr
    107, 114
    6b, 72
    info

    Switzerland Franc
    CHF
    CHF
    CHF
    67, 72, 70
    43, 48, 46

    Suriname Dollar
    SRD
    $
    $
    36
    24

    Syria Pound
    SYP
    £
    £
    163
    a3

    Taiwan New Dollar
    TWD
    NT$
    NT$
    78, 84, 36
    4e, 54, 24

    Thailand Baht
    THB
    ฿
    ฿
    3647
    e3f

    Trinidad and Tobago Dollar
    TTD
    TT$
    TT$
    84, 84, 36
    54, 54, 24

    Turkey Lira
    TRY
    8378
    20ba
    info

    Tuvalu Dollar
    TVD
    $
    $
    36
    24
    Ukraine Hryvnia
    UAH
    ₴
    ₴
    8372
    20b4
    United Kingdom Pound
    GBP
    £
    £
    163
    a3
    United States Dollar
    USD
    $
    $
    36
    24
    Uruguay Peso
    UYU
    $U
    $U
    36, 85
    24, 55
    Uzbekistan Som
    UZS
    лв
    лв
    1083, 1074
    43b, 432
    Venezuela Bolívar
    VEF
    Bs
    Bs
    66, 115
    42, 73
    Viet Nam Dong
    VND
    ₫
    ₫
    8363
    20ab
    Yemen Rial
    YER
    ﷼
    ﷼
    65020
    fdfc
    Zimbabwe Dollar             ZWD             Z$              Z$              90, 36              5a, 24
 */

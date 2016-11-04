package com.zisal.jelling.constant;

/**
 * Created on 11/9/15 9:55 AM.
 *
 * @author <a href="mailto:achmad.fauzi@sigma.co.id">Achmad Fauzi</a>
 */
public interface ApplicationConstant {

    final String COMPONENT_SCAN   = "com.zisal.jelling";
    final String BASE_PACKAGES    = "com.zisal";
    final long DAY_IN_MILLIS      = 1000 * 60 * 60 * 24;

    interface LOG{
        final String INFO           = "JELLING_INFO : {} ";
        final String DEBUG          = "JELLING_DEBUG : {} ";
        final String ERROR          = "JELLING_ERROR : {} ";
        final String WARN           = "JELLING_WARNING : {} ";
    }

    interface AUDITRAIL{
        String CREATED_BY           = "SYSTEM";
    }


    interface REST{
        final String REST_PATH    = "/rest/eod";

        interface EXAMPLE{
            final String EXAMPLE                    = "/example";
        }
        interface RECLEARING{
            final String LOAD_EOD_TX_INVOICE        = "/load/EODtxInvoice";
            final String RUN_RECLEARING_ADMIN       = "/runReclearingAdmin";
            final String RUN_RECLEARING_NON_ADMIN   = "/runReclearingNonAdmin";
        }

        interface CALCULATE_CF_NRC{
            final String CALCULATE_CF_USAGE_AND_FEE = "/calculateCFUsageAndFee";
            final String CALCULATE_ADM_FEE3         = "/calculateAdminFee3";
        }

        interface CHANGE_DATE{
            final String CHANGE_SYSTEM_DATE         = "/changeSystemDate";
            final String CHANGE_REPORT_DATE         = "/changeReportDate";
        }

        interface EOD_SETTLEMENT{
            String CALCULATE_CA_COMPENSATION        = "/calculateCACompensation";
        }

        interface CREATE_INVOICE{
            final String CREATE_CF_USAGE_AND_FEE_INVOICE = "/createCFUsageAndFeeInvoice";
            final String CREATE_ADMIN_FEE3_INVOICE       = "/createAdminFee3Invoice";
        }

    }

    interface SPRING_COMPONENT {
        interface SERVICE{
            final String RECLEARING_FEE_YES                 = "reclearingFeeYes";
            final String RECLEARING_INVOICE_NET_YES         = "reclearingInvoiceNetYes";
            final String CALCULATE_CFNRC                    = "calculateCFNRC";
            final String CHANGE_SYSTEM_DATE                 = "changeSystemDate";
            final String CHANGE_REPORT_DATE                 = "changeReportDate";
            final String CREATE_CF_USAGE_AND_FEE_INVOICE    = "createInvoice";
            final String CREATE_ADMIN_FEE3_INVOICE          = "createAdminFee3Invoice";
            final String CALCULATE_CA_COMPENSATION          = "calculateCACompensation";
        }
        interface PROCESS{
            final String RECLEARING_FEE_YES                 = "reclearingFeeYesProcess";
            final String RECLEARING_INVOICE_NET_YES         = "reclearingInvoiceNetYesProcess";
            final String UPDATE_CLEARING_POSITION           = "updateClearingPosition";
            final String CALCULATE_CF_NRC_SESSION3_YES      = "calculateCFNRCSession3Yes";
            final String CALCULATE_CF_NRC_SESSION3_NO       = "calculateCFNRCSession3No";
            final String SAVE_CF                            = "saveCf";
            final String ADMIN_FEE1_PROCESS                 = "adminFee1Process";
            final String NRC                                = "nRCProcess";
            final String FULL_PAYMENT_SESSION3_PROCESS      = "fullPaymentSession3Process";
            final String PARTIAL_PAYMENT_SESSION3_PROCESS   = "partialPaymentSession3Process";
            final String CREDIT_FACILITY_LOADER             = "creditFacilityLoader";
            final String ID_GENERATOR                       = "idGenerator";
            final String RECLEARING_INVOICE_NET_PROCESS     = "reclearingInvoiceNetProcess";
            final String CREATE_CFUSAGE_FEE_INVOICE_PROCESS = "createCFUsageAndFeeInvoiceProcess";
            final String CREATE_ADMIN_FEE3_INVOICE_PROCESS  = "createAdminFee3InvoiceProcess";
        }
    }

    interface BUSINESS_DAY{
        String HOLIDAY                              = "2";
    }

    interface PARAM_TABLE {
        interface GROUP_CODE{
            String INSTRUCTION_STATUS               = "INSTRUCTION_STATUS";
            String FEE_CLEARING_POSITION            = "FEE_CLEARING_POSITION";
            String INVOICE_NET_CLEARING_POSITION    = "INVOICE_NET_CLEARING_POSITION";
            String ADMIN_RATE_01                    = "ADMIN_RATE_01";
            String VAT_RATE                         = "VAT_RATE";
            String TAX_RATE                         = "TAX_RATE";
            String ADMIN_RATE_02                    = "ADMIN_RATE_02";
            String ADMIN_RATE_03                    = "ADMIN_RATE_03";
            String ADMIN_RATE_03_FLAT               = "ADMIN_RATE_03_FLAT";
            String SYSTEM_DATE                      = "SYSTEM_DATE";
            String FEE_TYPE                         = "FEE_TYPE";
            String FEE_STATUS                       = "FEE_STATUS";
            String PROCESS_STATUS                   = "PROCESS_STATUS";
            String PAYMENT_STATUS                   = "PAYMENT_STATUS";
            String INVOICE_DUE                      = "INVOICE_DUE";
            String INSTRUMENT_TYPE                  = "INSTRUMENT_TYPE";
            String BALANCE_TYPE                      = "BALANCE_TYPE";
        }
        interface INSTRUCTION_TYPE{
            String INSED3CASH                       = "INSED3CASH";
            String INSED2CASH                       = "INSED2CASH";
            String INSED2SEC                        = "INSED2SEC";
            String DVP2CM                           = "DVP2CM";
            String RVP2CM                           = "RVP2CM";
            String INSED2CF                         = "INSED2CF";
        }
        interface COMMON_CODE{
            String ZERO_ONE                         = "01";
            String ZERO_TWO                         = "02";
            String ZERO_THREE                       = "03";
            String YES                              = "Yes";
            String NO                               = "No";
            int ONE              = 1;
            int ZERO             = 0;
            int MINUS_ONE        = -1;
            String S_ZERO        = "0";
            String S_ONE         = "1";
            String S_TWO         = "2";
            String S_MINUS_ONE   = "-1";
            String SUCCESS       = "Success";
            String FAILED        = "Failed";
            String S_ZERO_ONE    = "01";
            String S_ZERO_TWO    = "02";
            Character C_ONE      = '1';
            Character C_ZERO     = '0';
            interface CURRENCY_CODE{
                String INDONESIAN_RUPIAH    = "IDR";
            }
            interface INVOICE_NET{
                String NET_LENDING          = "01";
                String NET_BORR             = "02";
                String NET_OFFER            = "03";
                String NET_BID              = "04";
            }
            interface FEE_CLEARING_POSITION{
                String CF_USAGE                                 = "01";
                String CF_NRC                                   = "02";
                String ADMIN_FEE_01                             = "03";
                String ADMIN_FEE_02                             = "04";
                String ADMIN_FEE_03                             = "05";
                String SUBSCRIBE_FEE_LENDER                     = "06";
                String SUBSCRIBE_FEE_BORROWER                   = "07";
                String BORROWING_FEE                            = "08";
                String BORROWING_FLAT_FEE                       = "09";
                String BORROWING_FIX_TERM_FEE                   = "10";
                String BORROWING_FIX_TERM_FLAT_FEE              = "11";
                String LENDING_FEE                              = "12";
                String LENDING_FIX_TERM_FEE                     = "13";
                String BORROWING_BID_OFFER_FEE                  = "14";
                String BORROWING_BID_OFFER_FLAT_FEE             = "15";
                String BORROWING_FIX_TERM_BID_OFFER_FEE         = "16";
                String BORROWING_FIX_TERM_BID_OFFER_FLAT_FEE    = "17";
                String LENDING_BID_OFFER_FEE                    = "18";
                String LENDING_FIX_TERM_BID_OFFER_FEE           = "19";
                String MISCELLENAOUS_FEE                        = "20";
                String ADMINISTRATION_FEE                       = "21";
                String CLEARING_FEE                             = "22";
                String LENDING_REVENUE                          = "23";
                String LENDING_FIX_TERM_REVENUE                 = "24";
                String PENALTY_BID_OFFER                        = "25";
                String BORROWING_FLAT_FEE_BID_OFFER             = "26";
                String BORROWING_FLAT_FEE_FIX_TERM_BID_OFFER    = "27";
                String BORROWING_FEE_BID_OFFER                  = "28";
                String KPEI_FEE_BID_OFFER                       = "29";
                String LENDING_REVENUE_BID_OFFER                = "30";
                String BORROWING_FIX_TERM_BID_OFFER             = "31";
                String LENDING_FIX_TERM_REVENUE_BID_OFFER       = "32";
            }
            interface FEE_TYPE{
                String CF_USAGE                                 = "01";
                String CF_NRC                                   = "02";
                String ADMIN_FEE_01                             = "03";
                String ADMIN_FEE_02                             = "04";
                String ADMIN_FEE_03                             = "05";
                String SUBSCRIBE_FEE_LENDER                     = "06";
                String SUBSCRIBE_FEE_BORROWER                   = "07";
                String BORROWING_FEE                            = "08";
                String BORROWING_FLAT_FEE                       = "09";
                String BORROWING_FIX_TERM_FEE                   = "10";
                String BORROWING_FIX_TERM_FLAT_FEE              = "11";
                String LENDING_FEE                              = "12";
                String LENDING_FIX_TERM_FEE                     = "13";
                String BORROWING_BID_OFFER_FEE                  = "14";
                String BORROWING_BID_OFFER_FLAT_FEE             = "15";
                String BORROWING_FIX_TERM_BID_OFFER_FEE         = "16";
                String BORROWING_FIX_TERM_BID_OFFER_FLAT_FEE    = "17";
                String LENDING_BID_OFFER_FEE                    = "18";
                String LENDING_FIX_TERM_BID_OFFER_FEE           = "19";
                String MISCELLENAOUS_FEE                        = "20";
                String ADMINISTRATION_FEE                       = "21";
                String CLEARING_FEE                             = "22";
                String LENDING_REVENUE                          = "23";
                String LENDING_FIX_TERM_REVENUE                 = "24";
                String PENALTY_BID_OFFER                        = "25";
                String BORROWING_FLAT_FEE_BID_OFFER             = "26";
                String BORROWING_FLAT_FEE_FIX_TERM_BID_OFFER    = "27";
                String BORROWING_FEE_BID_OFFER                  = "28";
                String KPEI_FEE_BID_OFFER                       = "29";
                String LENDING_REVENUE_BID_OFFER                = "30";
                String BORROWING_FIX_TERM_BID_OFFER             = "31";
                String LENDING_FIX_TERM_REVENUE_BID_OFFER       = "32";
            }
        }
        interface COMMON_VALUE{
            String FAILED                                       = "FAILED";
            String SETTLED                                      = "SETTLED";
            interface INSTRUMENT_TYPE{
                String CURRENCY                                 = "CURRENCY";
            }
            interface FEE_TYPE{
                String CF_USAGE                                 = "CF USAGE";
                String NRC                                      = "NRC CF USAGE";
                String ADMIN_FEE_01                             = "ADMIN FEE 01";
                String ADMIN_FEE_02                             = "ADMIN FEE 02";
                String ADMIN_FEE_03                             = "ADMIN FEE 03";
                String SUBSCRIBE_FEE_LENDER                     = "SUBS FEE LENDER";
                String SUBSCRIBE_FEE_BORROWER                   = "SUBS FEE BORROWER";
                String BORROWING_FEE                            = "BORR FEE";
                String BORROWING_FLAT_FEE                       = "BORR FLAT FEE";
                String BORROWING_FIX_TERM_FEE                   = "BORFT FEE";
                String BORROWING_FIX_TERM_FLAT_FEE              = "BORFT FLAT FEE";
                String LENDING_FEE                              = "LEND FEE";
                String LENDING_FIX_TERM_FEE                     = "LENDFT FEE";
                String BORROWING_BID_OFFER_FEE                  = "BORRBO FEE";
                String BORROWING_BID_OFFER_FLAT_FEE             = "BORRBO FLAT FEE";
                String BORROWING_FIX_TERM_BID_OFFER_FEE         = "BORRFTBO FEE";
                String BORROWING_FIX_TERM_BID_OFFER_FLAT_FEE    = "BORRFTBO FLAT FEE";
                String LENDING_BID_OFFER_FEE                    = "LENDBO FEE";
                String LENDING_FIX_TERM_BID_OFFER_FEE           = "LENDFTBO FEE";
                String ADMINISTRATION_FEE                       = "ADMINISTRATION FEE";
                String MISCELLENAOUS_FEE                        = "MISCELLENAOUS FEE";
            }
            interface FEE_STATUS{
                String TO_BE_CHECK                  = "TO BE CHECK";
                String TO_BE_APPROVE                = "TO BE APPROVE";
                String MODIFIED                     = "MODIFIED";
                String APPROVED                     = "APPROVED";
                String REJECTED                     = "REJECTED";
            }
            interface PAYMENT_STATUS{
                String UNPAID                       = "UNPAID";
                String PAID                         = "PAID";
            }
            interface PROCESS_STATUS{
                String NEW                          = "NEW";
                String MODIFY                       = "MODIFY";
            }
        }
        interface INVOICE_DUE{
            String D                                = "D";
            String _12                              = "12";
        }
        interface MOVEMENT_TYPE{
            Character DEBIT                         = 'D';
        }
        interface CREDIT_FACILITY_TYPE{
            String NRC                              = "20";
            String REGULAR                          = "01";
        }
        interface SYSTEM_DATE{
            String APPLICATION_DATE                 = "0";
            String REPORTING_DATE                   = "1";
        }
        interface INVOICE_STATUS{
            Character PAID                          = 'P';
            Character UN_PAID                       = 'U';
        }
        interface ADMIN_RATE{
            String PERCENTAGE                       = "P";
            String AMOUNT                           = "A";
        }
        interface ADMIN_FEE_PAYMENT{
            Character FULL                          = 'F';
            Character PARTIAL                       = 'P';
        }
    }
}

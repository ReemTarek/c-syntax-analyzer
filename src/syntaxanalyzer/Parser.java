package syntaxanalyzer;

import java.io.IOException;
import java.util.Queue;

public class Parser {

    Queue<Token> queue;

    public void getTokens(String fileName) throws IOException {
        Token obj = new Token();
        queue = obj.readTokens(fileName);
    }

    public Rule1 program() {
        Rule2 decl_listObj = decl_list();
        if (decl_listObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule1(decl_listObj));
    }

    private Rule2 decl_list() {
        Rule3 decl_list_dashObj = decl_list_dash();
        Rule4 declObj = decl();

        if (declObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule2(decl_list_dashObj, declObj));
    }

    private Rule3 decl_list_dash() {
        Rule4 declObj = decl();
        if (declObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        Rule3 decl_list_dashObj = decl_list_dash();
        return (new Rule3(declObj, decl_list_dashObj));
    }

    private Rule4 decl() {
        Rule5 var_declObj = var_decl();
        Rule8 fun_declObj = fun_decl();
        if (var_declObj == null && fun_declObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule4(var_declObj, fun_declObj));
    }

    private Rule5 var_decl() {
        Token type_spacObj = type_spac();
        Token var_decl_dashObj = var_decl_dash();
        if (type_spacObj == null || var_decl_dashObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule5(type_spacObj, var_decl_dashObj));
    }

    private Rule8 fun_decl() {
        Token type_spacObj = type_spac();
        Token IDENTObj = IDENT();
        Token LEFT_ROUND_BObj = LEFT_ROUND_B();
        Rule9 paramsObj = params();
        Token RIGHT_ROUND_BObj = RIGHT_ROUND_B();
        Rule19 compound_stmtObj = compound_stmt();
        if (type_spacObj == null || paramsObj == null || compound_stmtObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule8(type_spacObj, IDENTObj, LEFT_ROUND_BObj, paramsObj, RIGHT_ROUND_BObj, compound_stmtObj));
    }

    private Rule9 params() {
        Rule10 param_listObj = param_list();
        Token VOIDObj = VOID();
        if (param_listObj == null && VOIDObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule9(param_listObj, VOIDObj));
    }

    private Rule10 param_list() {
        Rule12 paramObj = param();
        Rule11 param_list_dashObj = param_list_dash();

        if (paramObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule10(paramObj, param_list_dashObj));
    }

    private Rule11 param_list_dash() {
        Token COMMAObj = COMMA();
        Rule12 paramObj = param();

        if (COMMAObj == null && paramObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        Rule11 param_list_dashObj = param_list_dash();

        return (new Rule11(COMMAObj, paramObj, param_list_dashObj));
    }

    private Rule12 param() {
        Token type_spacObj = type_spac();
        Token param_dashObj = param_dash();

        if (type_spacObj == null || param_dashObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule12(type_spacObj, param_dashObj));
    }

    private Rule14 stmt_list() {
        Rule15 stmt_list_dashObj = stmt_list_dash();

        return (new Rule14(stmt_list_dashObj));
    }

    private Rule15 stmt_list_dash() {
        Rule16 stmtObj = stmt();
        if (stmtObj == null) {
            System.out.println("Syntax Error");
            return null;
        }                
        Rule15 stmt_list_dashObj = stmt_list_dash();

        return (new Rule15(stmtObj, stmt_list_dashObj));
    }

    private Rule16 stmt() {
        Rule17 expr_stmtObj = expr_stmt();
        Rule19 compound_stmt_obj = compound_stmt();
        Rule24 if_stmtObj = if_stmt();
        Rule18 while_stmtObj = while_stmt();
        Rule26 return_stmtObj = return_stmt();
        Token break_stmtObj = break_stmt();

        if (expr_stmtObj == null && compound_stmt_obj == null && if_stmtObj == null
                && while_stmtObj == null && return_stmtObj == null && break_stmtObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule16(expr_stmtObj, compound_stmt_obj, if_stmtObj, while_stmtObj, return_stmtObj, break_stmtObj));
    }

    private Rule17 expr_stmt() {
        Rule_expr exprObj = expr();
        Token SEMICOLONObj = SEMICOLON();

        if ((exprObj == null || SEMICOLONObj == null) && SEMICOLONObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule17(exprObj, SEMICOLONObj));
    }

    private Rule18 while_stmt() {
        Token WHILEObj = WHILE();
        Token LEFT_CURLY_BObj = LEFT_CURLY_B();
        Rule28 exprObj = expr_28();
        Token RIGHT_CURLY_BObj = RIGHT_CURLY_B();
        Rule16 stmtObj = stmt();

        if (WHILEObj == null || LEFT_CURLY_BObj == null || exprObj == null || RIGHT_CURLY_BObj == null || stmtObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule18(WHILEObj, LEFT_CURLY_BObj, exprObj, RIGHT_CURLY_BObj, stmtObj));
    }

    private Rule19 compound_stmt() {
        Token LEFT_CURLY_BObj = LEFT_CURLY_B();
        Rule20 local_declsObj = local_decls();
        Rule14 stmt_listObj = stmt_list();
        Token RIGHT_CURLY_BObj = RIGHT_CURLY_B();
        if (LEFT_CURLY_BObj == null || local_declsObj == null || stmt_listObj == null || RIGHT_CURLY_BObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule19(LEFT_CURLY_BObj, local_declsObj, stmt_listObj, RIGHT_CURLY_BObj));
    }

    private Rule20 local_decls() {
        Rule21 local_decls_dashObj = local_decls_dash();

        return (new Rule20(local_decls_dashObj));
    }

    private Rule21 local_decls_dash() {
        Rule22 local_declObj = local_decl();

        if (local_declObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        Rule21 local_decls_dashObj = local_decls_dash();

        return (new Rule21(local_declObj, local_decls_dashObj));
    }

    private Rule22 local_decl() {
        Token type_spacObj = type_spac();
        Token local_decl_dashObj = var_decl_dash();

        if (type_spacObj == null || local_decl_dashObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule22(type_spacObj, local_decl_dashObj));
    }

    private Rule24 if_stmt() {
        Token IFObj = IF();
        Rule25 if_stmt_dashObj = if_stmt_dash();

        if (IFObj == null || if_stmt_dashObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule24(IFObj, if_stmt_dashObj));
    }

    private Rule25 if_stmt_dash() {
        Token LEFT_CURLY_BObj = LEFT_CURLY_B();
        Rule28 exprObj = expr_28();
        Token RIGHT_CURLY_BObj = RIGHT_CURLY_B();
        Rule16 stmtObj = stmt();
        Token ELSEObj = ELSE();

        if ((LEFT_CURLY_BObj == null || exprObj == null || RIGHT_CURLY_BObj == null || stmtObj == null)
                && (LEFT_CURLY_BObj == null || exprObj == null || RIGHT_CURLY_BObj == null || ELSEObj == null || stmtObj == null)) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule25(LEFT_CURLY_BObj, exprObj, RIGHT_CURLY_BObj, stmtObj, ELSEObj));
    }

    private Rule26 return_stmt() {
        Token RETURNObj = RETURN();
        Token SEMICOLONObj = SEMICOLON();
        Rule_expr exprObj = expr();

        if ((RETURNObj == null || SEMICOLONObj == null) && exprObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule26(RETURNObj, SEMICOLONObj, exprObj));
    }

    private Rule27 expr_27() {
        Token IDENTObj = IDENT();
        Token EQUALObj = EQUAL();
        Rule_expr exprObj = expr();
        Token LEFT_SQUARE_BObj = LEFT_SQUARE_B();
        Token RIGHT_SQUARE_BObj = RIGHT_SQUARE_B();

        if ((IDENTObj == null || EQUALObj == null || exprObj == null)
                && (IDENTObj == null || LEFT_SQUARE_BObj == null || exprObj == null || RIGHT_SQUARE_BObj == null || EQUALObj == null)) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule27(IDENTObj, EQUALObj, exprObj, LEFT_SQUARE_BObj, RIGHT_SQUARE_BObj));
    }

    private Rule28 expr_28() {
        Rule_expr_dash expr_dashObj = expr_dash();

        if (expr_dashObj == null) {
            System.out.print("Syntax Error");
            return null;
        }
        return (new Rule28(expr_dashObj));
    }

    private Rule29 expr_dash_29() {
        Token ORObj = OR();
        Rule_expr exprObj = expr();
        Rule_expr_dash expr_dashObj = expr_dash();

        return (new Rule29(ORObj, exprObj, expr_dashObj));
    }

    private Rule31 expr_dash_31() {
        Token EQObj = EQ();
        Rule_expr exprObj = expr();
        Rule_expr_dash expr_dashObj = expr_dash();
        Token NEObj = NE();

        return (new Rule31(EQObj, exprObj, expr_dashObj, NEObj));
    }

    private Rule33 expr_dash_33() {
        Token LEObj = LE();
        Rule_expr exprObj = expr();
        Rule_expr_dash expr_dashObj = expr_dash();
        Token LTObj = LT();
        Token GEObj = GE();
        Token GTObj = GT();

        return (new Rule33(LEObj, exprObj, expr_dashObj, LTObj, GEObj, GTObj));
    }

    private Rule35 expr_dash_35() {
        Token ANDObj = AND();
        Rule_expr exprObj = expr();
        Rule_expr_dash expr_dashObj = expr_dash();

        return (new Rule35(ANDObj, exprObj, expr_dashObj));
    }

    private Rule37 expr_dash_37() {
        Token PLUSObj = PLUS();
        Rule_expr exprObj = expr();
        Rule_expr_dash expr_dashObj = expr_dash();
        Token MINUSObj = MINUS();

        return (new Rule37(PLUSObj, exprObj, expr_dashObj, MINUSObj));
    }

    private Rule39 expr_dash_39() {
        Token ASTERICKObj = ASTERICK();
        Rule_expr exprObj = expr();
        Rule_expr_dash expr_dashObj = expr_dash();
        Token DIVIDEObj = DIVIDE();
        Token MODObj = MOD();

        return (new Rule39(ASTERICKObj, exprObj, expr_dashObj, DIVIDEObj, MODObj));
    }

    private Rule40 expr_40() {
        Token NOTObj = NOT();
        Rule_expr exprObj = expr();
        Token MINUSObj = MINUS();
        Token PLUSObj = PLUS();

        if ((NOTObj == null || exprObj == null) && (MINUSObj == null || exprObj == null) && (PLUSObj == null || exprObj == null)) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule40(NOTObj, exprObj, MINUSObj, PLUSObj));
    }

    private Rule41 expr_41() {
        Token LEFT_CURLY_BObj = LEFT_CURLY_B();
        Rule_expr exprObj = expr();
        Token RIGHT_CURLY_BObj = RIGHT_CURLY_B();

        if (LEFT_CURLY_BObj == null || exprObj == null || RIGHT_CURLY_BObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule41(LEFT_CURLY_BObj, exprObj, RIGHT_CURLY_BObj));
    }

    private Rule42 expr_42() {
        Token IDENTObj = IDENT();
        Token LEFT_SQUARE_BObj = LEFT_SQUARE_B();
        Rule_expr exprObj = expr();
        Token RIGHT_SQUARE_BObj = RIGHT_SQUARE_B();
        Token LEFT_CURLY_BObj = LEFT_CURLY_B();
        Rule46 argsObj = args();
        Token RIGHT_CURLY_BObj = RIGHT_CURLY_B();
        Token DOTObj = DOT();
        Token SIZEObj = SIZE();

        if ((IDENTObj == null) && (IDENTObj == null || LEFT_SQUARE_BObj == null || exprObj == null || RIGHT_SQUARE_BObj == null)
                && (IDENTObj == null || LEFT_CURLY_BObj == null || argsObj == null || RIGHT_CURLY_BObj == null)
                && (IDENTObj == null || DOTObj == null || SIZEObj == null)) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule42(IDENTObj, LEFT_SQUARE_BObj, exprObj, RIGHT_SQUARE_BObj, LEFT_CURLY_BObj, argsObj, RIGHT_CURLY_BObj, DOTObj, SIZEObj));
    }

    private Rule43 expr_43() {
        Token BOOL_LITERALObj = BOOL_LITERAL();
        Token INTEGRAL_LITERALObj = INTEGRAL_LITERAL();
        Token FLOAT_LITERALObj = FLOAT_LITERAL();
        Token NEWObj = NEW();
        Token type_spacObj = type_spac();
        Token LEFT_SQUARE_BObj = LEFT_SQUARE_B();
        Rule_expr exprObj = expr();
        Token RIGHT_SQUARE_BObj = RIGHT_SQUARE_B();

        if ((BOOL_LITERALObj == null) && (INTEGRAL_LITERALObj == null) && (FLOAT_LITERALObj == null)
                && (NEWObj == null || type_spacObj == null || LEFT_SQUARE_BObj == null || exprObj == null || RIGHT_SQUARE_BObj == null)) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule43(BOOL_LITERALObj, INTEGRAL_LITERALObj, FLOAT_LITERALObj, NEWObj, type_spacObj, LEFT_SQUARE_BObj, exprObj, RIGHT_SQUARE_BObj));
    }

    private Rule44 arg_list() {
        Rule_expr exprObj = expr();
        Rule45 arg_list_dashObj = arg_list_dash();

        if (exprObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule44(exprObj, arg_list_dashObj));
    }

    private Rule45 arg_list_dash() {
        Token COMMAObj = COMMA();
        Rule_expr exprObj = expr();
        Rule45 arg_list_dashObj = arg_list_dash();

        if (COMMAObj == null || exprObj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule45(COMMAObj, exprObj, arg_list_dashObj));
    }

    private Rule46 args() {
        Rule44 arg_listObj = arg_list();

        return (new Rule46(arg_listObj));
    }

    private Rule_expr expr() {
        Rule27 expr_27Obj = expr_27();
        Rule28 expr_28Obj = expr_28();
        Rule40 expr_40Obj = expr_40();
        Rule41 expr_41Obj = expr_41();
        Rule42 expr_42Obj = expr_42();
        Rule43 expr_43Obj = expr_43();

        if (expr_27Obj == null && expr_28Obj == null && expr_40Obj == null && expr_41Obj == null && expr_42Obj == null && expr_43Obj == null) {
            System.out.println("Syntax Error");
            return null;
        }
        return (new Rule_expr(expr_27Obj, expr_28Obj, expr_40Obj, expr_41Obj, expr_42Obj, expr_43Obj));
    }

    private Rule_expr_dash expr_dash() {
        Rule29 expr_dash_29Obj = expr_dash_29();
        Rule31 expr_dash_31Obj = expr_dash_31();
        Rule33 expr_dash_33Obj = expr_dash_33();
        Rule35 expr_dash_35Obj = expr_dash_35();
        Rule37 expr_dash_37Obj = expr_dash_37();
        Rule39 expr_dash_39Obj = expr_dash_39();

        return (new Rule_expr_dash(expr_dash_29Obj, expr_dash_31Obj, expr_dash_33Obj, expr_dash_35Obj, expr_dash_37Obj, expr_dash_39Obj));
    }

    private Token type_spac() {
        Token t = queue.peek();
        if (t.value.equals("void") || t.value.equals("bool") || t.value.equals("int") || t.value.equals("float")) {
            return queue.poll();
        }
        return null;
    }

    private Token var_decl_dash() {
        Token t = queue.peek();
        if (t.value.equals("id"))
        {
             queue.poll();
            Token t1 = queue.peek();
            if(t1.value.equals(";"))
                return queue.poll();
            else if(t1.value.equals("{"))
            {
                queue.poll();
                if(queue.peek().value.equals(";"))
                    return queue.poll();
            }
        }
        return null;
    }

    private Token IDENT() {
        Token t = queue.peek();
        if (t.tokenName.equals("<ID>")) {
            return queue.poll();
        }
        return null;
    }

    private Token LEFT_ROUND_B() {
        Token t = queue.peek();
        if (t.value.equals("(")) {
            return queue.poll();
        }
        return null;
    }

    private Token RIGHT_ROUND_B() {
        Token t = queue.peek();
        if (t.value.equals(")")) {
            return queue.poll();
        }
        return null;
    }

    private Token param_dash() {
        Token t = queue.peek();
        if (t.tokenName.equals("<ID>") ) {
            queue.poll();
            if(queue.peek().value.equals("["))
            {
                queue.poll();
                if(queue.peek().value.equals("]"))
                        return queue.poll();
            }
            return queue.poll();
            
        }
        return null;
    }

    private Token COMMA() {
        Token t = queue.peek();
        if (t.value.equals(",")) {
            return queue.poll();
        }
        return null;
    }

    private Token VOID() {
        Token t = queue.peek();
        if (t.value.equals("<VOID>")) {
            return queue.poll();
        }
        return null;
    }

    private Token LEFT_CURLY_B() {
        Token t = queue.peek();
        if (t.value.equals("{")) {
            return queue.poll();
        }
        return null;
    }

    private Token RIGHT_CURLY_B() {
        Token t = queue.peek();
        if (t.value.equals("}")) {
            return queue.poll();
        }
        return null;
    }

    private Token SEMICOLON() {
        Token t = queue.peek();
        if (t.value.equals(";")) {
            return queue.poll();
        }
        return null;
    }

    private Token NEW() {
        Token t = queue.peek();
        if (t.value.equals("new")) {
            return queue.poll();
        }
        return null;
    }

    private Token FLOAT_LITERAL() {
        Token t = queue.peek();
        if (t.tokenName.equals("<FLOAT_LITERAL>")) {
            return queue.poll();
        }
        return null;
    }

    private Token INTEGRAL_LITERAL() {
        Token t = queue.peek();
        if (t.tokenName.equals("<INTEGRAL_LITERAL>")) {
            return queue.poll();
        }
        return null;
    }

    private Token BOOL_LITERAL() {
        Token t = queue.peek();
        if (t.tokenName.equals("<BOOL_LITERAL>")) {
            return queue.poll();
        }
        return null;
    }

    private Token SIZE() {
        Token t = queue.peek();
        if (t.value.equals("size")) {
            return queue.poll();
        }
        return null;
    }

    private Token DOT() {
        Token t = queue.peek();
        if (t.value.equals(".")) {
            return queue.poll();
        }
        return null;
    }

    private Token NOT() {
        Token t = queue.peek();
        if (t.tokenName.equals("<NOT>")) {
            return queue.poll();
        }
        return null;
    }

    private Token MINUS() {
        Token t = queue.peek();
        if (t.tokenName.equals("<MINUS>")) {
            return queue.poll();
        }
        return null;
    }

    private Token PLUS() {
        Token t = queue.peek();
        if (t.tokenName.equals("<PLUS>")) {
            return queue.poll();
        }
        return null;
    }

    private Token EQUAL() {
        Token t = queue.peek();
        if (t.value.equals("=")) {
            return queue.poll();
        }
        return null;
    }

    private Token LEFT_SQUARE_B() {
        Token t = queue.peek();
        if (t.value.equals("[")) {
            return queue.poll();
        }
        return null;
    }

    private Token RIGHT_SQUARE_B() {
        Token t = queue.peek();
        if (t.value.equals("]")) {
            return queue.poll();
        }
        return null;
    }

    private Token IF() {
        Token t = queue.peek();
        if (t.tokenName.equals("<IF>")) {
            return queue.poll();
        }
        return null;
    }

    private Token ELSE() {
        Token t = queue.peek();
        if (t.tokenName.equals("<ELSE>")) {
            return queue.poll();
        }
        return null;
    }

    private Token WHILE() {
        Token t = queue.peek();
        if (t.tokenName.equals("<WHILE>")) {
            return queue.poll();
        }
        return null;
    }

    private Token RETURN() {
        Token t = queue.peek();
        if (t.tokenName.equals("<RETURN>")) {
            return queue.poll();
        }
        return null;
    }

    private Token break_stmt() {
        Token t = queue.peek();
        if (t.tokenName.equals("<BREAK>")) {
            return queue.poll();
        }
        return null;
    }

    private Token OR() {
        Token t = queue.peek();
        if (t.tokenName.equals("<OR>")) {
            return queue.poll();
        }
        return null;
    }

    private Token AND() {
        Token t = queue.peek();
        if (t.tokenName.equals("<AND>")) {
            return queue.poll();
        }
        return null;
    }

    private Token EQ() {
        Token t = queue.peek();
        if (t.value.equals("=")) {
            return queue.poll();
        }
        return null;
    }

    private Token NE() {
        Token t = queue.peek();
        if (t.value.equals("!=")) {
            return queue.poll();
        }
        return null;
    }

    private Token LE() {
        Token t = queue.peek();
        if (t.value.equals("<=")) {
            return queue.poll();
        }
        return null;
    }

    private Token LT() {
        Token t = queue.peek();
        if (t.value.equals("<")) {
            return queue.poll();
        }
        return null;
    }

    private Token GE() {
        Token t = queue.peek();
        if (t.value.equals(">=")) {
            return queue.poll();
        }
        return null;
    }

    private Token GT() {
        Token t = queue.peek();
        if (t.value.equals(">")) {
            return queue.poll();
        }
        return null;
    }

    private Token ASTERICK() {
        Token t = queue.peek();
        if (t.value.equals("*")) {
            return queue.poll();
        }
        return null;
    }

    private Token DIVIDE() {
        Token t = queue.peek();
        if (t.value.equals("/")) {
            return queue.poll();
        }
        return null;
    }

    private Token MOD() {
        Token t = queue.peek();
        if (t.value.equals("%")) {
            return queue.poll();
        }
        return null;
    }

}

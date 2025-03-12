package Código;
import static Código.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%
mold |
public |
inamov |
dat |
private |
bool |
int |
func |
main |
while |
if |
else |
loop |
simb |
float |
double |
long |
BEGIN |
END |
jump |
package |
collect |
diction |
parallel |
attempt |
panic |
explosion |
inherit |
create |
wait |
padlock |
link |
share {lexeme=yytext(); return Reservadas;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"(" | ")" | "{" | "}" | ";" | "," | "." | "@" {return Separador;}
":" | "<" | "<=" | ">" | ">=" | "like" | "notlike" | "&&" | "||" | "¡" {return Operador;}
"true" | "false" {return Booleano;}
"=" {return Igual;}
"+" {return Suma;}
"-" {return Resta;}
"*" {return Multiplicacion;}
"/" {return Division;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}
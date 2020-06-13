.MODEL	
.STACK	100H
.DATA
MSG	DB	'*******************************************',0DH,0AH
	DB	'*  WELCOME TO OUR ARREMBLY BASEBALL GAME  *'
	DB	0DH,0AH,'*******************************************',0DH,0AH
ADD1	DB	'*					  *',0DH,0AH
	DB	'*		  NOTICE		  *',0DH,0AH
ADD2	DB	'* 1. This game is consist of 9 inning     *',0DH,0AH
	DB	'* 2. You must use 1~9 between number	  *',0DH,0AH
	DB	'* 3. One inning cannot input same number  *',0DH,0AH
ADD3	DB	'*					  *',0DH,0AH
	DB	'*	 Made by INHA UNIVERSITY	  *',0DH,0AH
	DB	'* 	   Computer Engineering		  *',0DH,0AH
ADD12	DB	'*******************************************',0DH,0AH,'$'

RULE	DB	0DH,0AH,'*******************************************************',0DH,0AH
	DB	'*		GAME RULES		  *',0DH,0AH
	DB	'*******************************************************',0DH,0AH
ADD4	DB	'* 	     What is Strike? Ball? Out?		  *',0DH,0AH
	DB	'* ----------========<EX1>========---------- *',0DH,0AH
	DB	'* 	     If random number is 123		  *',0DH,0AH
ADD5	DB	'* 	       If input number is 135		  *',0DH,0AH
	DB	'* 	   1 is Strike, 3 is Ball, 5 is Out	  *',0DH,0AH
	DB	'* ----------========<EX2>========---------- *',0DH,0AH
ADD6	DB	'* 	     If random number is 471		  *',0DH,0AH
	DB	'* 	       If input number is 471		  *',0DH,0AH
	DB	'* 	   4 is Strike, 1 is Ball, 7 is Ball	  *',0DH,0AH
ADD11	DB	'*					  *',0DH,0AH
ADD7	DB	'* 	       Are you understand?		  *',0DH,0AH
	DB	'*					  *',0DH,0AH
ADD8	DB	'* 	   When before end of game		  *',0DH,0AH
	DB	'* 	   3 of numbers you made it.		  *',0DH,0AH
	DB	'* 	          It is [YOU WIN!]		  *',0DH,0AH
	DB	'* 		     else			  *',0DH,0AH
	DB	'* 	          It is [YOU LOSE!]		  *',0DH,0AH
	DB	'*					  *',0DH,0AH
ADD10	DB	'*       How can I quit when i playing game?         *',0DH,0AH
	DB	'* 	         Press [ESC] button		  *',0DH,0AH
	DB	'*******************************************************',0DH,0AH
MSG1	DB	0DH,0AH,'            Are you ready? (Press Y or N) $'
MSG2	DB	0DH,0AH,'                 Enter 3 numbers. EX)123 $'
INNING	DB	'1'
MSG4	DB	'	   inning or baseball game: $'
BYE_	DB	0DH,0AH,'                Good Bye see you next! $'
MSG5	DB	'	[Strike	= '
SCOUNT	DB	'0'
MSG6	DB	']',0DH,0AH,'	[Ball	= '
BCOUNT	DB	'0'
MSG7	DB	']',0DH,0AH,'	[Out	= '
OCOUNT	DB	'0'
MSG8	DB	']',0DH,0AH,'$'
SUCCESS	DB	0DH,0AH,'            CONGRATULATION! YOU WIN!',0DH,0AH
	DB	'	    RE GAME? (Y OR N) -> $'
FAIL_	DB	0DH,0AH,'                          YOU LOSE!',0DH,0AH,'	The answer is [$'
RETRY	DB	']',0DH,0AH,'	   TRY AGEIN? (Y OR N) -> $'
ERROR_	DB	0DH,0AH,'              ERROR! Please typing Y or N!',0DH,0AH,'$'
ERROR1_	DB	0DH,0AH,'                 Please enter number only!',0DH,0AH,'$'
ERROR2_	DB	0DH,0AH,'                        In 3 numbers '
	DB	'               same numbers can not input!',0DH,0AH,'$'
MSG9	DB	'        Do you know this game rules? (Y or N) -> $'
MSG10	DB	           'Do you want to Quit? (Y or N) -> $'

RAND_	DB	3	DUP	(0)
INPUT_	DB	3	DUP	(0)

.CODE
MAIN	PROC
	MOV	AX,@DATA
	MOV	DS,AX				;70
	MOV	AH,9
	LEA	DX,MSG
	INT	21H

@LETS_:
	LEA	DX,MSG9
	INT	21H
	MOV	AH,1
	INT	21H

	CMP	AL,'Y'
	JE	@STARTMSG_
	CMP	AL,'y'
	JE	@STARTMSG_
	CMP	AL,'N'
	JE	@RULEMSG_
	CMP	AL,'n'
	JE	@RULEMSG_
	LEA	DX,ERROR_
	MOV	AH,9
	INT	21H
	JMP	@LETS_
@RULEMSG_:
	LEA	DX,RULE
	MOV	AH,9


	INT	21H
@STARTMSG_:
	MOV	AH,9				;100
	LEA	DX,MSG1
	INT	21H
@TOP_:
	MOV	INNING,'1'
	MOV	CX,9
	MOV	AH,1
	INT	21H
	CMP	AL,'Y'
	JE	@START_
	CMP	AL, 'y'
	JE	@START_
	CMP	AL,'N'
	JE	@ENDJUMP_
	CMP	AL,'n'
	JE	@ENDJUMP_
	MOV	AH,9
	LEA	DX,ERROR_
	INT	21H
	LEA	DX,MSG1
	INT	21H
	JMP	@TOP_
@START_:
	CALL	MAKESEED
	XOR	SI,SI
	CALL	RAND
	INC	SI


@RANDMAKE:
	CALL	RAND					;130
	MOV	DL,RAND_[SI]
	CMP	DL,RAND_[SI-1]
	JE	@RANDMAKE
	INC	SI
@RANDMAKE1:
	CALL	RAND
	MOV	DL,RAND_[SI]
	CMP	DL,RAND_[SI-2]
	JE	@RANDMAKE1
	CMP	DL,RAND_[SI-1]
	JE	@RANDMAKE1
	XOR	SI,SI
	JMP	@DAP_
@ENDJUMP_:
	JMP	@ENDJUMP_1
@OUTQ:
	POP	CX
	LEA	DX,MSG10
	MOV	AH,9
	INT	21H
	MOV	AH,1
	INT	21H
	CMP	AL,'Y'
	JE	@ENDJUMP_


	CMP	AL,'y'
	JE	@ENDJUMP_
	CMP	AL,'N'
	JE	@DAP_					;160
	CMP	AL,'n'
	JE	@DAP_
	MOV	AH,9
	LEA	DX,ERROR_
	INT	21H
	JMP	@OUTQ
@DAP_:
	LEA	DX,MSG2					;169
	MOV	AH,9
	INT	21H
	XOR	SI,SI
@GOGO_:
	PUSH	CX
	MOV	SCOUNT,'0'
	MOV	BCOUNT,'0'
	MOV	OCOUNT,'0'
	MOV	CX,3
	LEA	DX,INNING
	INT	21H
@WHILE_1:
	MOV	AH,1
	INT	21H
	CMP	AL,1BH
	JE	@OUTQ
	CMP	AL,3AH

;358

	JGE	@ERROR_
	CMP	AL,30
	JLE	@ERROR_
	SUB	AL,30H
	MOV	INPUT_[SI],AL
	INC	SI
	LOOP	@WHILE_1
	XOR	SI,SI
	MOV	AL,INPUT_[SI]
	CMP	AL,INPUT_[SI+1]
	JE	@ERROR_2				;200
	CMP	AL,INPUT_[SI+2]
	JE	@ERROR_2
	INC	INNING
	MOV	CX,3
@STRIKE_CHK:
	MOV	AL,RAND_[SI]
	CMP	AL,INPUT_[SI]
	JE	@SCOUNT_
	INC	SI
	LOOP	@STRIKE_CHK
@STRIKE_GO:
	XOR	SI,SI					;211
	MOV	AL,INPUT_[SI]
	MOV	CX,2

;359

	JMP	@BALL_CHK1
@ERROR_:
	LEA	DX,ERROR1_
	MOV	AH,9
	INT	21H
	POP	CX
	JMP	@GOGO_
@ERROR_2:
	LEA	DX,ERROR2_				;225
	MOV	AH,9
	INT	21H
	POP	CX
	JMP	@GOGO_
@ENDJUMP_1:
	JMP	@ENDJUMP_2
@END_WHILE:
	LEA	DX,SUCCESS
	MOV	AH,9
	INT	21H
	JMP	@TOP_
@SCOUNT_:
	INC	SCOUNT
	INC	SI
	CMP	SCOUNT,'3'				;240
	JE	@END_WHILE
	LOOP	@STRIKE_CHK
	JMP	@STRIKE_GO
@GOGO_1:

;360

	JMP	@GOGO_
@GOTOP_1:
	JMP	@TOP_
@UPTO_:
	JMP	@WHILE_1
@BALL_CHK1:
	CMP	RAND_[SI+1],AL
	JE	@BCOUNT_1
@BALL_1:
	INC	SI
	LOOP	@BALL_CHK1
	XOR	SI,SI
	MOV	AL,INPUT_[SI+1]
	MOV	CX,2
@BALL_CHK2:
	CMP	RAND_[SI],AL				;263
	JE	@BCOUNT_2
@BALL_2:
	ADD	SI,2
	LOOP	@BALL_CHK2
	XOR	SI,SI
	MOV	AL,INPUT_[SI+2]
	MOV	CX,2
@BALL_CHK3:
	CMP	RAND_[SI],AL				;272
	JE	@BCOUNT_3
@BALL_3:
	INC	SI
	LOOP	@BALL_CHK3

;361

	JMP	@OUT_CHK
@GOGO_2:
	JMP	@GOGO_1
@GOTOP_2:
	JMP	@GOTOP_1
@ENDJUMP_2:
	JMP	@BYE_
@BCOUNT_1:
	INC	BCOUNT
	JMP	@BALL_1
@BCOUNT_2:						;290
	INC	BCOUNT
	JMP	@BALL_2
@BCOUNT_3:
	INC	BCOUNT
	JMP	@BALL_3
@OUT_CHK:
	MOV	DL,'3'
	SUB	DL,SCOUNT
	ADD	DL,30H
	SUB	DL,BCOUNT
	ADD	DL,30H
	MOV	OCOUNT,DL
@END_:
	POP	CX
	MOV	AH,2
	MOV	DL,0DH					;311
	INT	21H

;362

	MOV	DL,0AH
	INT	21H
	MOV	AH,9
	LEA	DX,MSG5
	INT	21H
	XOR	SI,SI
	LOOP	@GOGO_2
@FIN_:
	MOV	AH,9
	LEA	DX,FAIL_
	INT	21H
	MOV	CX,3
@ANSWER:
	MOV	AH,2
	MOV	DL,RAND_[SI]
	ADD	DL,30H
	MOV	AH,2
	INT	21H
	INC	SI
	LOOP	@ANSWER
@FINQ:
	MOV	AH,9
	LEA	DX,RETRY
	INT	21H
	MOV	AH,1
	INT	21H
	CMP	AL,'Y'

;363

	JE	@GOTOP_2
	CMP	AL, 'y'
	JE	@GOTOP_2
	CMP	AL,'N'
	JE	@BYE_
	CMP	AL,'n'
	JE	@BYE_
	MOV	AH,9
	LEA	DX,ERROR_
	INT	21H
	JMP	@FINQ
@BYE_:
	MOV	AH,9
	LEA	DX,BYE_
	INT	21H
	MOV	AH,4CH
	INT	21H
MAIN	ENDP

INCLUDE RANDOM.ASM

	END	MAIN
.MODEL	SMALL
.STACK	100H
.CODE
MAIN	PROC
	MOV	AH,2
	MOV	DL,'?'
	INT	21H

	MOV	CX,0

	MOV	AH,1
	INT	21H

	CMP	AL,'-'
	JE	@MINUS		;-기호라면 MINUS로 이동

	CMP	AL,'+'
	JE	@PLUS		;+기호라면 PLUS로 이동
	
	JMP	@SAVE		;숫자라면 SAVE로 이동한다

@MINUS:
	MOV	CX,1		;CX를 1로 바꾼다

@PLUS:
	INT	21H		;숫자를 입력받는다

@SAVE:
	SUB	AL,30H		;2진수로 전환한다
	MOV	BL,AL
	CMP	CX,1		;음수인지 판단

	JNE	@NEXT1		;양수라면 NEXT1

	NEG	BL		;음수라면 2의보수로 바꿔준다 (양수)

@NEXT1:
	CMP	BL,0		;양수인지 판단
	JGE	@NEXT2		;양수라면 NEXT2

	NEG	BL		;음수라면 2의보수로 바꿔준다 (양수)

@NEXT2:
	MOV	AH,2
	MOV	DL,0DH
	INT	21H
	MOV	DL,0AH
	INT	21H

	MOV	DL,BL
	ADD	DL,30H		;다시 숫자로 바꿔준다
	INT	21H

	MOV	AH,4CH
	INT	21H
MAIN	ENDP
	END	MAIN
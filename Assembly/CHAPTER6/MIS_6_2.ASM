.MODEL	SMALL
.STACK	100H
.CODE
MAIN	PROC
;숫자 -> 대문자 -> 소문자 판별순으로 카운트한다
	MOV	BL,0
	MOV	AH,2
	MOV	DL,'?'
	INT	21H

	MOV	AH,1
	INT	21H
@WHILE:
	CMP	AL,0DH
	JE	@END_WHILE
	CMP	AL,'0'
	JL	@NEXT
	CMP	AL,'9'
	JLE	@PLUS
	CMP	AL,'A'
	JL	@NEXT
	CMP	AL,'Z'
	JLE	@PLUS
	CMP	AL,'a'
	JL	@NEXT
	CMP	AL,'z'
	JG	@NEXT
@PLUS:
	INC	BL
@NEXT:
	INT	21H
	JMP	@WHILE
@END_WHILE:
	MOV	AH,2
	MOV	DL,0DH
	INT	21H
	MOV	DL,0AH
	INT	21H
	MOV	DL,BL
	ADD	DL,30H
	INT	21H

	MOV	AH,4CH
	INT	21H
MAIN	ENDP
	END	MAIN
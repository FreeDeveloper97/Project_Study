.MODEL	SMALL
.STACK	100H
.CODE
MAIN	PROC
	MOV	AH,2
	MOV	DL,'?'
	INT	21H

	MOV	AH,1
	INT	21H
	MOV	BL,AL

	INT	21H
	MOV	BH,AL

	SUB	BL,30H	;숫자로 변환
	SUB	BH,30H	;숫자로 변환

	MOV	AH,2
	MOV	DL,0DH
	INT	21H
	MOV	DL,0AH
	INT	21H

	ADD	BL,BH	;두숫자 더하기

	CMP	BL,10
	JL	@PRINT
	SUB	BL,10
	
	MOV	DL,'1'
	INT	21H
@PRINT:
	ADD	BL,30H	;아스키코드로 변환
	MOV	DL,BL
	INT	21H

	MOV	AH,4CH
	INT	21H
MAIN	ENDP
	END	MAIN
.MODEL	SMALL
.STACK	100H
.CODE
MAIN	PROC
	MOV	AH,2
	MOV	DL,'?'
	INT	21H

	MOV	AH,1
	INT	21H
	MOV	BH,AL

	INT	21H
	MOV	BL,AL

	MOV	AH,2
	MOV	DL,0DH
	INT	21H
	MOV	DL,0AH
	INT	21H

	SUB	BH,30H
	SUB	BL,30H
	ADD	BL,BH

	CMP	BL,10
	JB	@PRT
	MOV	DL,'1'
	INT	21H
	SUB	BL,10
@PRT:
	ADD	BL,30H
	MOV	DL,BL
	INT	21H

	MOV	AH,4CH
	INT	21H
MAIN	ENDP
	END	MAIN
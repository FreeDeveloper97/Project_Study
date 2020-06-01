.MODEL	SMALL
.STACK	100H
.CODE
MAIN	PROC
;0~9 사이의 수를 입력 받고 입력 받은 수의 10의 보수를 구하여 출력하는 프로그램을 작성하라.
	MOV	AH,2
	MOV	DL,"?"
	INT	21H

	MOV	AH,1
	INT	21H
	SUB	AL,30H	;?? 2진수로 변환
	NEG	AL	;?? 음수로 만든다
	ADD	AL,10	;?? 10을 더하여 10의 보수를 구한다
	MOV	BL,AL	;10의 보수값 BL에 저장

	MOV	AH,2
	MOV	DL,0DH
	INT	21H
	MOV	DL,0AH
	INT	21H
	MOV	DL,BL
	ADD	DL,30H	;?? 30H를 더하여 ASCII 값으로 변환한다
	INT	21H

	MOV	AH,4CH
	INT	21H
MAIN	ENDP
	END	MAIN

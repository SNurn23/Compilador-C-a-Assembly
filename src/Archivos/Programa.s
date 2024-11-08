	.file	"Programa.cpp"
	.text
	.section	.text$_Z5scanfPKcz,"x"
	.linkonce discard
	.globl	__Z5scanfPKcz
	.def	__Z5scanfPKcz;	.scl	2;	.type	32;	.endef
__Z5scanfPKcz:
LFB38:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	pushl	%ebx
	subl	$36, %esp
	.cfi_offset 3, -12
	leal	12(%ebp), %eax
	movl	%eax, -16(%ebp)
	movl	-16(%ebp), %ebx
	movl	$0, (%esp)
	movl	__imp____acrt_iob_func, %eax
	call	*%eax
	movl	%ebx, 8(%esp)
	movl	8(%ebp), %edx
	movl	%edx, 4(%esp)
	movl	%eax, (%esp)
	call	___mingw_vfscanf
	movl	%eax, -12(%ebp)
	movl	-12(%ebp), %eax
	movl	-4(%ebp), %ebx
	leave
	.cfi_restore 5
	.cfi_restore 3
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
LFE38:
	.section	.text$_Z6printfPKcz,"x"
	.linkonce discard
	.globl	__Z6printfPKcz
	.def	__Z6printfPKcz;	.scl	2;	.type	32;	.endef
__Z6printfPKcz:
LFB44:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	pushl	%ebx
	subl	$36, %esp
	.cfi_offset 3, -12
	leal	12(%ebp), %eax
	movl	%eax, -16(%ebp)
	movl	-16(%ebp), %ebx
	movl	$1, (%esp)
	movl	__imp____acrt_iob_func, %eax
	call	*%eax
	movl	%ebx, 8(%esp)
	movl	8(%ebp), %edx
	movl	%edx, 4(%esp)
	movl	%eax, (%esp)
	call	___mingw_vfprintf
	movl	%eax, -12(%ebp)
	movl	-12(%ebp), %eax
	movl	-4(%ebp), %ebx
	leave
	.cfi_restore 5
	.cfi_restore 3
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
LFE44:
	.section .rdata,"dr"
	.align 4
LC0:
	.ascii "Ingrese la cantidad de clientes en la cola: \0"
LC1:
	.ascii "%d\0"
	.align 4
LC2:
	.ascii "Ingrese el tiempo promedio de llegada entre clientes (en minutos): \0"
	.align 4
LC3:
	.ascii "Ingrese el tiempo promedio de servicio por cliente (en minutos): \0"
LC4:
	.ascii "\12Simulaci\303\263n de la cola:\12\0"
	.align 4
LC5:
	.ascii "Cliente %d - Tiempo de llegada: %d min, Tiempo de inicio de servicio: %d min, Tiempo de fin de servicio: %d min, Tiempo de espera: %d min\12\0"
	.align 4
LC6:
	.ascii "\12Tiempo de espera total para %d clientes: %d minutos\12\0"
LC7:
	.ascii "pause\0"
LC8:
	.ascii "cls\0"
	.text
	.globl	_main
	.def	_main;	.scl	2;	.type	32;	.endef
_main:
LFB187:
	.cfi_startproc
	pushl	%ebp
	.cfi_def_cfa_offset 8
	.cfi_offset 5, -8
	movl	%esp, %ebp
	.cfi_def_cfa_register 5
	andl	$-16, %esp
	subl	$80, %esp
	call	___main
	movl	$0, 76(%esp)
	movl	$0, 72(%esp)
	movl	$0, 68(%esp)
	movl	$0, 64(%esp)
	movl	$LC0, (%esp)
	call	__Z6printfPKcz
	leal	52(%esp), %eax
	movl	%eax, 4(%esp)
	movl	$LC1, (%esp)
	call	__Z5scanfPKcz
	movl	$LC2, (%esp)
	call	__Z6printfPKcz
	leal	48(%esp), %eax
	movl	%eax, 4(%esp)
	movl	$LC1, (%esp)
	call	__Z5scanfPKcz
	movl	$LC3, (%esp)
	call	__Z6printfPKcz
	leal	44(%esp), %eax
	movl	%eax, 4(%esp)
	movl	$LC1, (%esp)
	call	__Z5scanfPKcz
	movl	$LC4, (%esp)
	call	__Z6printfPKcz
	movl	$1, 56(%esp)
	jmp	L6
L10:
	movl	48(%esp), %eax
	addl	%eax, 72(%esp)
	movl	72(%esp), %eax
	cmpl	64(%esp), %eax
	jle	L7
	movl	72(%esp), %eax
	movl	%eax, 68(%esp)
	jmp	L8
L7:
	movl	64(%esp), %eax
	movl	%eax, 68(%esp)
L8:
	movl	44(%esp), %edx
	movl	68(%esp), %eax
	addl	%edx, %eax
	movl	%eax, 64(%esp)
	movl	68(%esp), %eax
	subl	72(%esp), %eax
	movl	%eax, 60(%esp)
	cmpl	$0, 60(%esp)
	jns	L9
	movl	$0, 60(%esp)
L9:
	movl	60(%esp), %eax
	addl	%eax, 76(%esp)
	movl	60(%esp), %eax
	movl	%eax, 20(%esp)
	movl	64(%esp), %eax
	movl	%eax, 16(%esp)
	movl	68(%esp), %eax
	movl	%eax, 12(%esp)
	movl	72(%esp), %eax
	movl	%eax, 8(%esp)
	movl	56(%esp), %eax
	movl	%eax, 4(%esp)
	movl	$LC5, (%esp)
	call	__Z6printfPKcz
	addl	$1, 56(%esp)
L6:
	movl	52(%esp), %eax
	cmpl	%eax, 56(%esp)
	jle	L10
	movl	52(%esp), %eax
	movl	76(%esp), %edx
	movl	%edx, 8(%esp)
	movl	%eax, 4(%esp)
	movl	$LC6, (%esp)
	call	__Z6printfPKcz
	movl	$LC7, (%esp)
	call	_system
	movl	$LC8, (%esp)
	call	_system
	movl	$0, %eax
	leave
	.cfi_restore 5
	.cfi_def_cfa 4, 4
	ret
	.cfi_endproc
LFE187:
	.def	___main;	.scl	2;	.type	32;	.endef
	.ident	"GCC: (i686-mcf-dwarf-rev0, Built by MinGW-Builds project) 14.2.0"
	.def	___mingw_vfscanf;	.scl	2;	.type	32;	.endef
	.def	___mingw_vfprintf;	.scl	2;	.type	32;	.endef
	.def	_system;	.scl	2;	.type	32;	.endef

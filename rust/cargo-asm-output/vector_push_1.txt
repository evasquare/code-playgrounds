        .globl  std::rt::lang_start
        .p2align        2
std::rt::lang_start:
Lfunc_begin1:
        .cfi_startproc
        sub sp, sp, #32
        .cfi_def_cfa_offset 32
        stp x29, x30, [sp, #16]
        add x29, sp, #16
        .cfi_def_cfa w29, 16
        .cfi_offset w30, -8
        .cfi_offset w29, -16
        mov x4, x3
        mov x3, x2
        mov x2, x1
        str x0, [sp, #8]
Lloh0:
        adrp x1, l___unnamed_1@PAGE
Lloh1:
        add x1, x1, l___unnamed_1@PAGEOFF
        add x0, sp, #8
        bl std::rt::lang_start_internal
        .cfi_def_cfa wsp, 32
        ldp x29, x30, [sp, #16]
        add sp, sp, #32
        .cfi_def_cfa_offset 0
        .cfi_restore w30
        .cfi_restore w29
        ret
        .loh AdrpAdd    Lloh0, Lloh1
Lfunc_end1:
        .cfi_endproc

        .p2align        2
std::rt::lang_start::{{closure}}:
Lfunc_begin2:
        .cfi_startproc
        stp x29, x30, [sp, #-16]!
        .cfi_def_cfa_offset 16
        mov x29, sp
        .cfi_def_cfa w29, 16
        .cfi_offset w30, -8
        .cfi_offset w29, -16
        ldr x0, [x0]
        bl std::sys_common::backtrace::__rust_begin_short_backtrace
        mov w0, #0
        .cfi_def_cfa wsp, 16
        ldp x29, x30, [sp], #16
        .cfi_def_cfa_offset 0
        .cfi_restore w30
        .cfi_restore w29
        ret
Lfunc_end2:
        .cfi_endproc

        .p2align        2
core::ops::function::FnOnce::call_once{{vtable.shim}}:
Lfunc_begin3:
        .cfi_startproc
        stp x29, x30, [sp, #-16]!
        .cfi_def_cfa_offset 16
        mov x29, sp
        .cfi_def_cfa w29, 16
        .cfi_offset w30, -8
        .cfi_offset w29, -16
        ldr x0, [x0]
        bl std::sys_common::backtrace::__rust_begin_short_backtrace
        mov w0, #0
        .cfi_def_cfa wsp, 16
        ldp x29, x30, [sp], #16
        .cfi_def_cfa_offset 0
        .cfi_restore w30
        .cfi_restore w29
        ret
Lfunc_end3:
        .cfi_endproc

        .p2align        2
core::ptr::drop_in_place<std::rt::lang_start<()>::{{closure}}>:
Lfunc_begin4:
        .cfi_startproc
        ret
Lfunc_end4:
        .cfi_endproc

        .p2align        2
playground::main:
Lfunc_begin5:
        .cfi_startproc
        sub sp, sp, #112
        .cfi_def_cfa_offset 112
        stp x29, x30, [sp, #96]
        add x29, sp, #96
        .cfi_def_cfa w29, 16
        .cfi_offset w30, -8
        .cfi_offset w29, -16
Lloh2:
        adrp x8, ___rust_no_alloc_shim_is_unstable@GOTPAGE
Lloh3:
        ldr x8, [x8, ___rust_no_alloc_shim_is_unstable@GOTPAGEOFF]
        ldrb wzr, [x8]
        bl std::time::Instant::now
        str x0, [sp]
        str w1, [sp, #8]
        mov x0, sp
        bl std::time::Instant::elapsed
        stur x0, [x29, #-16]
        stur w1, [x29, #-8]
        sub x8, x29, #16
Lloh4:
        adrp x9, <core::time::Duration as core::fmt::Debug>::fmt@GOTPAGE
Lloh5:
        ldr x9, [x9, <core::time::Duration as core::fmt::Debug>::fmt@GOTPAGEOFF]
        stp x8, x9, [x29, #-32]
Lloh6:
        adrp x8, l___unnamed_2@PAGE
Lloh7:
        add x8, x8, l___unnamed_2@PAGEOFF
        mov w9, #2
        stp x8, x9, [sp, #16]
        sub x8, x29, #32
        mov w9, #1
        str x8, [sp, #32]
        stp x9, xzr, [sp, #40]
        add x0, sp, #16
        bl std::io::stdio::_print
        .cfi_def_cfa wsp, 112
        ldp x29, x30, [sp, #96]
        add sp, sp, #112
        .cfi_def_cfa_offset 0
        .cfi_restore w30
        .cfi_restore w29
        ret
        .loh AdrpAdd    Lloh6, Lloh7
        .loh AdrpLdrGot Lloh4, Lloh5
        .loh AdrpLdrGot Lloh2, Lloh3
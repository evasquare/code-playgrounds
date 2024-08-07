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
        sub sp, sp, #160
        .cfi_def_cfa_offset 160
        stp x22, x21, [sp, #112]
        stp x20, x19, [sp, #128]
        stp x29, x30, [sp, #144]
        add x29, sp, #144
        .cfi_def_cfa w29, 16
        .cfi_offset w30, -8
        .cfi_offset w29, -16
        .cfi_offset w19, -24
        .cfi_offset w20, -32
        .cfi_offset w21, -40
        .cfi_offset w22, -48
Lloh2:
        adrp x8, ___rust_no_alloc_shim_is_unstable@GOTPAGE
Lloh3:
        ldr x8, [x8, ___rust_no_alloc_shim_is_unstable@GOTPAGEOFF]
        ldrb wzr, [x8]
        bl std::time::Instant::now
        str x0, [sp, #8]
        str w1, [sp, #16]
        mov w8, #3
        str w8, [sp, #28]
        add x8, sp, #28
Lloh4:
        adrp x9, core::fmt::num::imp::<impl core::fmt::Display for i32>::fmt@GOTPAGE
Lloh5:
        ldr x9, [x9, core::fmt::num::imp::<impl core::fmt::Display for i32>::fmt@GOTPAGEOFF]
        stp x8, x9, [x29, #-48]
Lloh6:
        adrp x8, l___unnamed_2@PAGE
Lloh7:
        add x8, x8, l___unnamed_2@PAGEOFF
        mov w19, #2
        stp x8, x19, [sp, #32]
        sub x20, x29, #48
        mov w21, #1
        str x20, [sp, #48]
        stp x21, xzr, [sp, #56]
        add x0, sp, #32
        bl std::io::stdio::_print
        add x0, sp, #8
        bl std::time::Instant::elapsed
        stur x0, [x29, #-48]
        stur w1, [x29, #-40]
Lloh8:
        adrp x8, <core::time::Duration as core::fmt::Debug>::fmt@GOTPAGE
Lloh9:
        ldr x8, [x8, <core::time::Duration as core::fmt::Debug>::fmt@GOTPAGEOFF]
        stp x20, x8, [x29, #-64]
Lloh10:
        adrp x8, l___unnamed_3@PAGE
Lloh11:
        add x8, x8, l___unnamed_3@PAGEOFF
        stp x8, x19, [sp, #32]
        stp x21, xzr, [sp, #56]
        sub x8, x29, #64
        str x8, [sp, #48]
        add x0, sp, #32
        bl std::io::stdio::_print
        .cfi_def_cfa wsp, 160
        ldp x29, x30, [sp, #144]
        ldp x20, x19, [sp, #128]
        ldp x22, x21, [sp, #112]
        add sp, sp, #160
        .cfi_def_cfa_offset 0
        .cfi_restore w30
        .cfi_restore w29
        .cfi_restore w19
        .cfi_restore w20
        .cfi_restore w21
        .cfi_restore w22
        ret
        .loh AdrpAdd    Lloh10, Lloh11
        .loh AdrpLdrGot Lloh8, Lloh9
        .loh AdrpAdd    Lloh6, Lloh7
        .loh AdrpLdrGot Lloh4, Lloh5
        .loh AdrpLdrGot Lloh2, Lloh3
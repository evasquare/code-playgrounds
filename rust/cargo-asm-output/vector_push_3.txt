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
        .cfi_personality 155, _rust_eh_personality
        .cfi_lsda 16, Lexception0
        sub sp, sp, #128
        .cfi_def_cfa_offset 128
        stp x20, x19, [sp, #96]
        stp x29, x30, [sp, #112]
        add x29, sp, #112
        .cfi_def_cfa w29, 16
        .cfi_offset w30, -8
        .cfi_offset w29, -16
        .cfi_offset w19, -24
        .cfi_offset w20, -32
        .cfi_remember_state
Lloh2:
        adrp x8, ___rust_no_alloc_shim_is_unstable@GOTPAGE
Lloh3:
        ldr x8, [x8, ___rust_no_alloc_shim_is_unstable@GOTPAGEOFF]
        ldrb wzr, [x8]
        mov w0, #16
        mov w1, #4
        bl ___rust_alloc
        cbz x0, LBB5_5
        mov x19, x0
        bl std::time::Instant::now
        str x0, [sp]
        str w1, [sp, #8]
        str x19, [sp, #16]
        ldr x8, [sp, #16]
        str x19, [sp, #16]
        ldr x8, [sp, #16]
        str x19, [sp, #16]
        ldr x8, [sp, #16]
        mov w8, #1
        stp wzr, w8, [x19]
        str x19, [sp, #16]
        ldr x8, [sp, #16]
        str x19, [sp, #16]
        ldr x8, [sp, #16]
        mov w9, #2
        str x19, [sp, #16]
        ldr x8, [sp, #16]
        str x19, [sp, #16]
        ldr x8, [sp, #16]
        mov w8, #3
        stp w9, w8, [x19, #8]
        str x19, [sp, #16]
        ldr x8, [sp, #16]
        mov x0, sp
        bl std::time::Instant::elapsed
        stur x0, [x29, #-32]
        stur w1, [x29, #-24]
        sub x8, x29, #32
Lloh4:
        adrp x9, <core::time::Duration as core::fmt::Debug>::fmt@GOTPAGE
Lloh5:
        ldr x9, [x9, <core::time::Duration as core::fmt::Debug>::fmt@GOTPAGEOFF]
        stp x8, x9, [x29, #-48]
Lloh6:
        adrp x8, l___unnamed_2@PAGE
Lloh7:
        add x8, x8, l___unnamed_2@PAGEOFF
        mov w9, #2
        stp x8, x9, [sp, #16]
        sub x8, x29, #48
        mov w9, #1
        str x8, [sp, #32]
        stp x9, xzr, [sp, #40]
        add x0, sp, #16
        bl std::io::stdio::_print
        mov x0, x19
        mov w1, #16
        mov w2, #4
        bl ___rust_dealloc
        .cfi_def_cfa wsp, 128
        ldp x29, x30, [sp, #112]
        ldp x20, x19, [sp, #96]
        add sp, sp, #128
        .cfi_def_cfa_offset 0
        .cfi_restore w30
        .cfi_restore w29
        .cfi_restore w19
        .cfi_restore w20
        ret
        .cfi_restore_state
        mov w0, #4
        mov w1, #16
        bl alloc::alloc::handle_alloc_error
        mov x20, x0
        mov x0, x19
        mov w1, #16
        mov w2, #4
        bl ___rust_dealloc
        mov x0, x20
        bl __Unwind_Resume
        .loh AdrpLdrGot Lloh2, Lloh3
        .loh AdrpAdd    Lloh6, Lloh7
        .loh AdrpLdrGot Lloh4, Lloh5
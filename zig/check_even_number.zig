const std = @import("std");

fn checkEvenNumber(n: u32) bool {
    return n % 2 == 0;
}

test "checkEvenNumber" {
    const expect = std.testing.expect;

    try expect(checkEvenNumber(2) == true);
    try expect(checkEvenNumber(3) == false);
    try expect(checkEvenNumber(0) == true);
    try expect(checkEvenNumber(31) == false);
}

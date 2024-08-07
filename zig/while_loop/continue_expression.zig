const std = @import("std");

pub fn main() !void {
    var sum: u8 = 0;
    var i: u8 = 1;

    while (i <= 10) : (i += 1) {
        std.debug.print("sum: {d}, i: {d}", .{ sum, i });
        sum += i;
    }
}

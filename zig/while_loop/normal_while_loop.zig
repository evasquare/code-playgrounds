const std = @import("std");

pub fn main() !void {
    var sum: u8 = 0;

    while (sum < 30) {
        sum += 1;
    }

    std.debug.print("sum: {d}", .{sum});
}

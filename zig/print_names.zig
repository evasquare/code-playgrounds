const std = @import("std");

pub fn main() !void {
    var names = [_][]const u8{ "Rachel", "Julian", "Isaac", "Anthony" };

    for (names, 0..) |name, index| {
        std.debug.print("{d} Hello, {s}!\n", .{ index, name });
    }
}

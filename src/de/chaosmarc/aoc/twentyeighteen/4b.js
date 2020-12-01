input = $("pre").innerHTML.split("\n").slice(0, -1).sort();
guards = [];
times = [];

for (i = 0; i < input.length; i++) {
    row = input[i].slice(6).split("] ");
    time = row[0].split(" ")[1].split(":");
    action = row[1];
    if (action.startsWith("Guard")) {
        id = action.split("#")[1].split(" ")[0];
        start = [0, 0];
        end = [0, 0];
        if (times[id] === undefined) {
            times[id] = new Array(60).fill(0);
        }
    } else if (action == "falls asleep") {
        start = time;
    } else if (action == "wakes up") {
        end = time;
        duration = end[1] - start[1];
        for (m = start[1]; m < end[1]; m++) {
            times[id][m] = (parseInt(times[id][m]) || 0) + 1;
        }
        guards[id] = (parseInt(guards[id]) || 0) + duration;
    }
}
maxM = 0;
maxI = 0;
guard = "";

for (var g in times) {
    console.log("Guard " + g + ": " + times[g]);
    for (i = 0; i < 60; i++) {
        if (times[g][i] > maxM) {
            guard = g
            maxM = times[g][i];
            maxI = i;
            console.log("new max " + maxM + " - " + maxI + " - " + guard);
        }
    }
}

console.log(guard + " " + times[guard] + " -> " + maxI + " (" + maxM + ")");
console.log(guard + " * " + maxI + " = " + (guard * maxI));
input = $("pre").innerHTML.split("\n").slice(0, -1);

graph = {};
for (i = 0; i < input.length; i++) {
    tmp = input[i].split(" must be finished before step ");
    node = tmp[1].slice(0, 1);
    dependency = tmp[0].slice(5);
    graph[node] = (graph[node] || "") + dependency;
    if (graph[dependency] === undefined) {
        graph[dependency] = "";
    }
}
sorted = {};
keys = Object.keys(graph).sort();
for (k in keys) {
    node = keys[k];
    sorted[node] = graph[node];
}

order = []
while (Object.keys(sorted).length > 0) {
    inner:
        for (node in sorted) {
            if (sorted[node] == "" && !order.includes(node)) {
                order.push(node)
                delete sorted[node];
                for (node in sorted) {
                    str = order.join("|");
                    var re = new RegExp(str, "g");
                    sorted[node] = sorted[node].replace(re, "");
                }
                break;
            }
        }
}

console.log(order.join(""));
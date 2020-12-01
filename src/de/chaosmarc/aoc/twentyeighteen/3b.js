input = $("pre").innerHTML.split("\n").slice(0, -1);
matrix = new Array(1000).fill(0).map(() => new Array(1000).fill(0));
claims = new Array(input.length - 1).fill(true);

for (i = 0; i < input.length; i++) {
    line = input[i].slice(1).split(" @ ");
    tmp = line[1].split(": ");
    coords = tmp[0].split(",")
    dims = tmp[1].split("x");

    id = line[0];
    posX = parseInt(coords[0]);
    posY = parseInt(coords[1]);
    dimX = parseInt(dims[0]);
    dimY = parseInt(dims[1]);

    for (x = posX; x <= posX + dimX - 1; x++) {
        for (y = posY; y <= posY + dimY - 1; y++) {
            if (matrix[x][y] > 0) {
                claims[id] = false;
                claims[matrix[x][y]] = false;
            }
            matrix[x][y] = id;
        }
    }
}

for (i = 1; i < claims.length; i++) {
    if (claims[i] == true) {
        console.log("intact: " + i);
    }
}
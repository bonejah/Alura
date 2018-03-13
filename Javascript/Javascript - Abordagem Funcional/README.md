# Course JavaScript: De padrões a uma abordagem funcional

* To run project execute: node server

# Examples:

* Array Filter
```
const numbers = [1,2,3,4,5,6,7,8,9,10];
const filteredNumbers = numbers.filter(number => number % 2);

Result: [1, 3, 5, 7, 9]
```

* Array map
```
const numbers = [1,2,3,4,5,6,7,8,9,10];
const newNumbers = numbers.map(number => {
    if(number % 2) return ++number
    return number;
});

Result: [2, 2, 4, 4, 6, 6, 8, 8, 10, 10]
```

* Reduce
```
const numbers = [1,2,3,4,5,6,7,8,9,10];
const sum = numbers
    .reduce((previous, number) => 
        previous + number, 0);
```

* Example Refactor 
```
Before
for (let [key, value] of stores) {
    if(transactionalConn.objectStoreNames.contains(store)) 
        transactionalConn.deleteObjectStore(store);
    transactionalConn.createObjectStore(store, { autoIncrement: true });
}

After
const storeExists(conn, store) => conn.objectStoreNames.contains(store);
const createStore(conn, store) => conn.createObjectStore(store, { autoIncrement: true });
const deleteStore(conn, store) => conn.deleteObjectStore(store);

for (let [key, value] of stores) {
    if(storeExists(conn, store)) deleteStore(store);
    createStore(conn, store);
}
```
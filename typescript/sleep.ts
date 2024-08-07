const sleep = (ms: number) => {
    return new Promise((resolve) => setTimeout(resolve, ms));
};

const main = async () => {
    await sleep(3000);
    console.log("Howdy partner!");
};

main();

const express = require("express");
const app = express();
const mongoose = require("mongoose");
const authRouter = require("./routes/auth");
const env = require("dotenv");
const cors = require("cors");


env.config();

mongoose
  .connect(process.env.MONGOO_CNX)
  .then(() => console.log("mongoose Connect successful"))
  .catch(() => console.log("no cnx"));



app.use(cors());
app.use(express.json());
app.use("/api/auth", authRouter);


app.listen(process.env.PORT || 8085, () => {
  console.log("api is ready");
});

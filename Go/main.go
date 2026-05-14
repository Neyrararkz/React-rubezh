package main

import (
	"go-rubezh/database"
	"go-rubezh/routes"
)

func main() {
	database.InitDB()
	r := routes.SetupRouter()
	r.Run(":8080")
}



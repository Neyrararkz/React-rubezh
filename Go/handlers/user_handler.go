package handlers

import (
	"go-rubezh/database"
	"go-rubezh/models"
	"net/http"
	"github.com/gin-gonic/gin"
)

func GetPing(c *gin.Context) {
	c.JSON(http.StatusOK, gin.H{"message": "server is working"})
}

func GetUsers(c *gin.Context) {
	rows, err := database.DB.Query("SELECT id, name, email FROM users")
	if err != nil {
		c.JSON(http.StatusInternalServerError, gin.H{"error": err.Error()})
		return
	}
	defer rows.Close()

	var users []models.User 
	for rows.Next() {
		var u models.User
		if err := rows.Scan(&u.ID, &u.Name, &u.Email); err != nil {
			continue
		}
		users = append(users, u)
	}
	c.JSON(http.StatusOK, users)
}
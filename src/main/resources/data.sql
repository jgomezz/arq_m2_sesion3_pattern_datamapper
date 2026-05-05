-- ========================================
-- SCRIPT DE CARGA DE DATOS INICIALES
-- Base de datos: H2
-- ========================================

-- Limpiar datos existentes (opcional)
DELETE FROM tasks;

-- Resetear secuencia de IDs
ALTER TABLE tasks ALTER COLUMN id RESTART WITH 1;

-- ========================================
-- INSERTAR TAREAS DE EJEMPLO
-- ========================================

-- Tareas pendientes (completada = false)
INSERT INTO tasks (titulo, descripcion, completada) VALUES
('Aprender Spring Boot', 'Estudiar los fundamentos de Spring Boot y crear proyectos de práctica', FALSE);
INSERT INTO tasks (titulo, descripcion, completada) VALUES
('Implementar Repository Pattern', 'Aplicar el patrón Repository con Spring Data JPA y H2', FALSE);
INSERT INTO tasks (titulo, descripcion, completada) VALUES
('Configurar base de datos H2', 'Configurar H2 en memoria con scripts SQL de inicialización', FALSE);
INSERT INTO tasks (titulo, descripcion, completada) VALUES
('Crear controladores MVC', 'Desarrollar controladores para gestionar las operaciones CRUD', FALSE);

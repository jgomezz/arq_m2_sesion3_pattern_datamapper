-- ========================================
-- SCRIPT DE CREACIÓN DE TABLAS
-- Base de datos: H2
-- ========================================

-- Eliminar tabla si existe (para recrear limpiamente)
DROP TABLE IF EXISTS tasks;

-- Crear tabla tasks
CREATE TABLE tasks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    descripcion VARCHAR(1000),
    completada BOOLEAN NOT NULL DEFAULT FALSE
);

-- Crear índices para mejorar rendimiento
CREATE INDEX idx_tasks_completada ON tasks(completada);
CREATE INDEX idx_tasks_titulo ON tasks(titulo);

-- Comentarios de documentación
COMMENT ON TABLE tasks IS 'Tabla para almacenar tareas del sistema';
COMMENT ON COLUMN tasks.id IS 'Identificador único de la tarea';
COMMENT ON COLUMN tasks.titulo IS 'Título descriptivo de la tarea';
COMMENT ON COLUMN tasks.descripcion IS 'Descripción detallada de la tarea (opcional)';
COMMENT ON COLUMN tasks.completada IS 'Estado de completitud de la tarea';
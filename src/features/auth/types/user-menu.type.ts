import type { ReactNode } from "react";
import type { Menu } from "./menu.type";

export type UserMenu = {
  label: string;
  icon: ReactNode;
  type: Menu;
  payload: string;
  isDestructive?: boolean;
};

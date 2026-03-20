import { waveCircle } from "@lucide/lab";
import { Icon } from "lucide-react";

interface LogoProps {
  size: number;
}

const Logo = ({ size = 24 }: LogoProps) => {
  return <Icon iconNode={waveCircle} size={size} />;
};

export default Logo;
